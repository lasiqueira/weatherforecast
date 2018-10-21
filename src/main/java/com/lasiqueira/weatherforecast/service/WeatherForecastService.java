package com.lasiqueira.weatherforecast.service;

import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import com.lasiqueira.weatherforecast.api.external.dto.OpenWeatherMapDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherForecastService {
    private Logger logger;
    private OpenWeatherMapAPI openWeatherMapAPI;
    private String apiKey;
    private String unit;

    public WeatherForecastService(OpenWeatherMapAPI openWeatherMapAPI, @Value("apikey")String apiKey, @Value("units") String unit) {
        this.logger =  LoggerFactory.getLogger(WeatherForecastService.class);
        this.openWeatherMapAPI = openWeatherMapAPI;
        this.apiKey = apiKey;
        this.unit = unit;
    }



    public WeatherForecastMetrics getWeatherForecastMetrics(String city){
        //TODO implement
        return null;
    }

    private OpenWeatherMapDTO getWeatherForecast(String city) throws IOException {
        return openWeatherMapAPI.getWeather5Day(city, unit, apiKey)
                .execute()
                .body();
    }


}
