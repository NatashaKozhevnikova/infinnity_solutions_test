package com.example.weather.controller;

import com.example.weather.entity.Provider;
import com.example.weather.entity.Weather;
import com.example.weather.json.OpenWeatherResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class WeatherRestService extends AbstractWeatherController {

    public WeatherRestService() {
        super.setProviderType(Provider.ApiType.REST);
    }

    @Override
    public void downloadWeather(String city, Provider provider) {
        try {
            OpenWeatherResponse response = (OpenWeatherResponse) super.sendGetRequest(
                    provider.getUrl().replaceAll("%city%", city), OpenWeatherResponse.class);
            if (response == null) return;
            BigDecimal temp = response.getTemp();
            logger.info("Температура {} для города {}", temp, city);
            weatherService.saveWeather(new Weather(city, temp, provider));
        } catch (Exception e) {
            logger.error("Ошибка запроса для города {}:", city, e);
        }
    }
}
