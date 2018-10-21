package com.lasiqueira.weatherforecast.api.dto.v1;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class WeatherForecastMetricsDTO {
    private final BigDecimal averageTemperatureDay;
    private final BigDecimal averageTemperatureNight;
    private final BigDecimal averagePressure;
}
