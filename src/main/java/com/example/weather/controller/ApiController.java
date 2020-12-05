package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

/**
 * Контроллер для получения данных из базы.
 * Средняя температура вычисляется за указанную дату
 * по всем провайдерам. Если дата не указана, то считается
 * за сегодня
 */
@RestController
@RequestMapping("/weather")
public class ApiController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherService weatherService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/average")
    public BigDecimal getAverageTemperature(@RequestParam String city,
                                        @RequestParam(required = false) String date) {
        logger.info("Получили запрос для {} за дату {}", city, date);
        Float result;
        try {
            if (date == null) {
                result = weatherService.getAverageTemperature(city);
            } else {
                result = weatherService.getAverageTemperature(city, sdf.parse(date));
            }
        } catch (Exception e) {
            logger.error("Ошибка при выполнении запроса для города {}", city, e);
            return null;
        }
        return new BigDecimal(result).setScale(2, RoundingMode.HALF_DOWN);
    }
}
