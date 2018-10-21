package com.lasiqueira.weatherforecast.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WeatherForecastMetrics {
    private final BigDecimal averageTemperatureDay;
    private final BigDecimal averageTemperatureNight;
    private final BigDecimal averagePressure;
}
