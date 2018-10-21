package com.lasiqueira.weatherforecast.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherForecastMetrics {
    private final Double averageTemperatureDay;
    private final Double averageTemperatureNight;
    private final Double averagePressure;
}
