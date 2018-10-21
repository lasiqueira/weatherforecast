package com.lasiqueira.weatherforecast.api.dto.v1;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherForecastMetricsDTO {
    private final Double averageTemperatureDay;
    private final Double averageTemperatureNight;
    private final Double averagePressure;
}
