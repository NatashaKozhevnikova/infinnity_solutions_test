package com.example.weather.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse implements Serializable {
    private OpenWeatherMain main;

    public OpenWeatherMain getMain() {
        return main;
    }

    public void setMain(OpenWeatherMain main) {
        this.main = main;
    }

    public float getTemp() {
        return this.main.getTemp();
    }

    static class OpenWeatherMain {
        private float temp;

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }
    }
}
