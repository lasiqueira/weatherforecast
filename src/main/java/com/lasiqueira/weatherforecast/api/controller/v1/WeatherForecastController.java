package com.lasiqueira.weatherforecast.api.controller.v1;

import com.lasiqueira.weatherforecast.api.converter.v1.WeatherForecastConverter;
import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.service.WeatherForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/data")
public class WeatherForecastController {
    private Logger logger;
    private WeatherForecastConverter weatherForecastConverter;
    private WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastConverter weatherForecastConverter, WeatherForecastService weatherForecastService) {
        this.logger = LoggerFactory.getLogger(WeatherForecastController.class);
        this.weatherForecastConverter = weatherForecastConverter;
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping(value="/cities/{city}", produces = "application/json")
    public ResponseEntity<WeatherForecastMetricsDTO> getWeatherForecastByCity(@PathVariable String city){
        //TODO implement
        return null;
    }
}
