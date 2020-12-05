package com.example.weather.controller;

import com.example.weather.entity.Provider;
import com.example.weather.json.OpenWeatherResponse;
import org.springframework.stereotype.Service;

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
            saveTempToDb(city, provider, response.getTemp());
        } catch (Exception e) {
            logger.error("Ошибка запроса для города {}:", city, e);
        }
    }
}
