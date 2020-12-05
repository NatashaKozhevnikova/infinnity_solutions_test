package com.example.weather.controller;

import com.example.weather.entity.Provider;
import com.example.weather.service.WeatherSoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Сервис получения данных о погоде через SOAP.
 */
@Service
public class WeatherSoapService extends AbstractWeatherController {

    @Autowired
    private WeatherSoapClient soapClient;

    public WeatherSoapService() {
        super.setProviderType(Provider.ApiType.SOAP);
    }

    @Override
    public void downloadWeather(String city, Provider provider) {
        BigDecimal temp = soapClient.getTemperature(city, provider.getUrl());
        saveTempToDb(city, provider, temp);
    }
}
