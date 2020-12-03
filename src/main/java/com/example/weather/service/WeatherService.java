package com.example.weather.service;

import com.example.weather.entity.Provider;
import com.example.weather.entity.Weather;
import com.example.weather.repositories.ProviderRepository;
import com.example.weather.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WeatherService {
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private WeatherRepository weatherRepository;

    public Float getAverageTemperature(String city) {
        return getAverageTemperature(city, new Date());
    }

    public Float getAverageTemperature(String city, Date date) {
        List<Weather> weatherList = weatherRepository.findAllByCityAndDate(city, date);
        if (weatherList.size() == 0) return null;
        Float result = 0f;
        for (Weather obj : weatherList) {
            result += obj.getTemperature();
        }

        return result / weatherList.size();
    }

    public Provider getProvider(Provider.ApiType type) {
        return providerRepository.findFirstByType(type).orElse(null);
    }

    public void saveWeather(Weather weather) {
        weatherRepository.saveAndFlush(weather);
    }
}
