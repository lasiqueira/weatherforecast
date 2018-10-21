package com.lasiqueira.weatherforecast.api.converter.v1;

import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastConverter {
    private Logger logger;

    public WeatherForecastConverter() {
        this.logger = LoggerFactory.getLogger(WeatherForecastConverter.class);
    }

    public WeatherForecastMetricsDTO convertModelToDTO(WeatherForecastMetrics weatherForecastMetrics){
        logger.debug("convertModelToDTO: {}", weatherForecastMetrics);
        return WeatherForecastMetricsDTO
                .builder()
                .averagePressure(weatherForecastMetrics.getAveragePressure())
                .averageTemperatureDay(weatherForecastMetrics.getAverageTemperatureDay())
                .averageTemperatureNight(weatherForecastMetrics.getAverageTemperatureNight())
                .build();

    }
}
