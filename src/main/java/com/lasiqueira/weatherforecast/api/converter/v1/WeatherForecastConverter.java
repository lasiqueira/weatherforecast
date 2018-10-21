package com.lasiqueira.weatherforecast.api.converter.v1;

import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastConverter {
    public WeatherForecastMetricsDTO convertModelToDTO(WeatherForecastMetrics weatherForecastMetrics){
        return WeatherForecastMetricsDTO
                .builder()
                .averagePressure(weatherForecastMetrics.getAveragePressure())
                .averageTemperatureDay(weatherForecastMetrics.getAverageTemperatureDay())
                .averageTemperatureNight(weatherForecastMetrics.getAverageTemperatureNight())
                .build();

    }
}
