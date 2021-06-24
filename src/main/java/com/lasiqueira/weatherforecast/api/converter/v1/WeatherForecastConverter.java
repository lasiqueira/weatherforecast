package com.lasiqueira.weatherforecast.api.converter.v1;

import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastConverter {
    private final Logger logger;

    public WeatherForecastConverter() {
        this.logger = LoggerFactory.getLogger(WeatherForecastConverter.class);
    }

    public WeatherForecastMetricsDTO convertModelToDTO(WeatherForecastMetrics weatherForecastMetrics){
        logger.debug("convertModelToDTO: {}", weatherForecastMetrics);
        return new WeatherForecastMetricsDTO(
                weatherForecastMetrics.getAverageTemperatureDay(),
                weatherForecastMetrics.getAverageTemperatureNight(),
                weatherForecastMetrics.getAveragePressure()
        );


    }
}
