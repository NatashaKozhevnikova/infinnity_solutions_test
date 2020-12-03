package com.example.weather.controller;

import com.example.weather.entity.Provider;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public abstract class AbstractWeatherController extends AbstractRestController {
    Provider.ApiType providerType;

    @Autowired
    WeatherService weatherService;
    @Value("${cities}")
    private String citiesList;

    @Scheduled(fixedRate = 300000)
    private void process() {
        Provider provider = weatherService.getProvider(this.providerType);
        if (provider != null) {
            logger.info("Запускаем выгрузку для {}", provider.getName());
            for (String city : getCities()) {
                downloadWeather(city.intern(), provider);
            }
        }
    }

    public abstract void downloadWeather(String city, Provider provider);

    public void setProviderType(Provider.ApiType providerType) {
        this.providerType = providerType;
    }

    public List<String> getCities() {
        return Arrays.asList(citiesList.split("\\|"));
    }
}
