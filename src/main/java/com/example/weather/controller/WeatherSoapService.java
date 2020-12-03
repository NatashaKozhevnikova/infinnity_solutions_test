package com.example.weather.controller;

import com.example.weather.entity.Provider;
import org.springframework.stereotype.Service;

@Service
public class WeatherSoapService extends AbstractWeatherController {

    public WeatherSoapService() {
        super.setProviderType(Provider.ApiType.SOAP);
    }

    @Override
    public void downloadWeather(String city, Provider provider) {

    }
}
