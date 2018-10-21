package com.lasiqueira.weatherforecast.api.controller.v1;

import com.lasiqueira.weatherforecast.api.converter.v1.WeatherForecastConverter;
import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.api.exception.v1.InvalidDataException;
import com.lasiqueira.weatherforecast.api.validator.v1.WeatherForecastValidator;
import com.lasiqueira.weatherforecast.service.WeatherForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("v1/data")
public class WeatherForecastController {
    private final Logger logger;
    private final WeatherForecastConverter weatherForecastConverter;
    private final WeatherForecastService weatherForecastService;
    private final WeatherForecastValidator weatherForecastValidator;

    public WeatherForecastController(WeatherForecastConverter weatherForecastConverter,
                                     WeatherForecastService weatherForecastService,
                                     WeatherForecastValidator weatherForecastValidator) {
        this.logger = LoggerFactory.getLogger(WeatherForecastController.class);
        this.weatherForecastConverter = weatherForecastConverter;
        this.weatherForecastService = weatherForecastService;
        this.weatherForecastValidator = weatherForecastValidator;
    }

    // Since we will get by city and country code, in order to be more RESTful I separated the country code from the city and made them both resources
    @GetMapping(value="/cities/{city}/countries/{countryCode}", produces = "application/json")
    public ResponseEntity<WeatherForecastMetricsDTO> getWeatherForecastByCity(@PathVariable String city, @PathVariable String countryCode) throws InvalidDataException, IOException {
        Integer cityId = weatherForecastValidator.validateCityAndCountry(city, countryCode);
        return ResponseEntity.ok(weatherForecastConverter.convertModelToDTO(weatherForecastService.getWeatherForecastMetrics(cityId)));
    }
}
