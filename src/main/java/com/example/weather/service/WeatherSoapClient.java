
package com.example.weather.service;

import com.example.weather.wsdl.GetWeatherRequest;
import com.example.weather.wsdl.GetWeatherResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Сервис обработки SOAP-запросов
 */
public class WeatherSoapClient extends WebServiceGatewaySupport {

    public BigDecimal getTemperature(String city, String url) {
        return BigDecimal.valueOf(getTemp(city, url)).setScale(2, RoundingMode.HALF_DOWN);
    }

	private float getTemp(String city, String url) {
	    return getWeather(city, url).getTemperature();
    }

	private GetWeatherResponse getWeather(String city, String url) {
		GetWeatherRequest request = new GetWeatherRequest();
		request.setCity(city);
		GetWeatherResponse response = (GetWeatherResponse) getWebServiceTemplate()
				.marshalSendAndReceive(url, request);
		return response;
	}

}
