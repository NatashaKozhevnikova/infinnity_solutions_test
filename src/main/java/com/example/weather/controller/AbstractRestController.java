package com.example.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Абстракция для отправки REST запросов
 */
public class AbstractRestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public Object sendGetRequest(String url, Class responseClass) {
        ResponseEntity responseEntity = sendRequest(url, null, responseClass, HttpMethod.GET);
        logger.info("Получили ответ {}", responseEntity.getStatusCode());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }

    public ResponseEntity sendPostRequest(String url, String body, Class responseClass) {
        return sendRequest(url, body, responseClass, HttpMethod.POST);
    }

    public ResponseEntity sendRequest(String url, String body, Class responseClass, HttpMethod httpMethod) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpEntity request = new HttpEntity(body);

        try {
            ResponseEntity response = restTemplate.exchange(url, httpMethod, request, responseClass);
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Ошибка при выполнении запроса {} {}: {}", httpMethod, url, e.getMessage());
            return new ResponseEntity(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
