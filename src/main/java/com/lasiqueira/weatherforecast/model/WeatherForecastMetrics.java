package com.lasiqueira.weatherforecast.model;

import java.math.BigDecimal;

public record WeatherForecastMetrics(BigDecimal averageTemperatureDay,
                                     BigDecimal averageTemperatureNight,
                                     BigDecimal averagePressure) {
}
