package com.lasiqueira.weatherforecast.model;

import lombok.Data;

@Data
public class WeatherForecastMetrics {
    private int averageTemperatureDay;
    private int averageTemperatureNight;
    private int averagePressure;
}
