package com.lasiqueira.weatherforecast.api.dto.v1;

import java.math.BigDecimal;

public record WeatherForecastMetricsDTO(BigDecimal averageTemperatureDay,
                                        BigDecimal averageTemperatureNight,
                                        BigDecimal averagePressure) {

}
