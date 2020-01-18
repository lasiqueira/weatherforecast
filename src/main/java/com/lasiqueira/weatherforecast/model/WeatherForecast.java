package com.lasiqueira.weatherforecast.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WeatherForecast {
    private BigDecimal temperature;
    private BigDecimal pressure;
    private LocalDateTime timestamp;

    WeatherForecast(BigDecimal temperature, BigDecimal pressure, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.timestamp = timestamp;
    }

    public static WeatherForecastBuilder builder() {
        return new WeatherForecastBuilder();
    }

    public static class WeatherForecastBuilder {
        private BigDecimal temperature;
        private BigDecimal pressure;
        private LocalDateTime timestamp;

        WeatherForecastBuilder() {
        }

        public WeatherForecastBuilder temperature(BigDecimal temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherForecastBuilder pressure(BigDecimal pressure) {
            this.pressure = pressure;
            return this;
        }

        public WeatherForecastBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public WeatherForecast build() {
            return new WeatherForecast(temperature, pressure, timestamp);
        }

        public String toString() {
            return "WeatherForecast.WeatherForecastBuilder(temperature=" + this.temperature + ", pressure=" + this.pressure + ", timestamp=" + this.timestamp + ")";
        }
    }
}
