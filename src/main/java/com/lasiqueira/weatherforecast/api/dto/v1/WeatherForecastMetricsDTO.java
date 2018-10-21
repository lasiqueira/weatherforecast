package com.lasiqueira.weatherforecast.api.dto.v1;

import lombok.Builder;

@Builder
public class WeatherForecastMetricsDTO {
    private int averageTemperatureDay;
    private int averageTemperatureNight;
    private int averagePressure;
}
