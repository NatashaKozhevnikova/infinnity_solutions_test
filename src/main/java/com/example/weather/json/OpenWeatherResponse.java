package com.example.weather.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse implements Serializable {
    private OpenWeatherMain main;

    public OpenWeatherMain getMain() {
        return main;
    }

    public void setMain(OpenWeatherMain main) {
        this.main = main;
    }

    public BigDecimal getTemp() {
        return this.main.getTemp();
    }

    static class OpenWeatherMain {
        private BigDecimal temp;

        public BigDecimal getTemp() {
            return temp;
        }

        public void setTemp(BigDecimal temp) {
            this.temp = temp;
        }
    }
}
