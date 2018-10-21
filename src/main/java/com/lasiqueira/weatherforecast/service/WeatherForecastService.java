package com.lasiqueira.weatherforecast.service;

import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import com.lasiqueira.weatherforecast.api.external.dto.Info;
import com.lasiqueira.weatherforecast.api.external.dto.OpenWeatherMapDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class WeatherForecastService {
    private final Logger logger;
    private final OpenWeatherMapAPI openWeatherMapAPI;
    private final String apiKey;
    private static final String UNIT = "metric";

    public WeatherForecastService(OpenWeatherMapAPI openWeatherMapAPI, @Value("${apikey}") String apiKey) {
        this.logger = LoggerFactory.getLogger(WeatherForecastService.class);
        this.openWeatherMapAPI = openWeatherMapAPI;
        this.apiKey = apiKey;
    }


    public WeatherForecastMetrics getWeatherForecastMetrics(Integer cityId) throws IOException {
        logger.debug("getWeatherForecastMetrics: {}", cityId);
        OpenWeatherMapDTO openWeatherMapDTO = getWeatherForecast(cityId);
        return extractMetrics(openWeatherMapDTO.getInfo());
    }

    private OpenWeatherMapDTO getWeatherForecast(Integer cityId) throws IOException {
       logger.debug("getWeatherForecast: {}", cityId);
        return openWeatherMapAPI.getWeather5Day(cityId, UNIT, apiKey)
                .execute()
                .body();
    }

    private WeatherForecastMetrics extractMetrics(List<Info> infoList) {
        logger.debug("extractMetrics");
        Double avgDaily = 0.0;
        Double avgNighly = 0.0;
        Double avgPressure = 0.0;
        //The OpenWeatherMap API returns a fix set of data
        // but I made it dynamic in case the API changes
        int count = 0;
        for (Info info : infoList) {
            //getting only the following 3 days
            if (isValidDateInterval(info.getDtTxt().toLocalDate())) {
                //I considered daily to be from 6 to less than 18
                // and nightly from 18 to less than 6 in order to
                // avoid using the same time period for both calculations
                if (isDaily(info.getDtTxt().toLocalTime())) {
                    avgDaily += info.getMain().getTemp();
                } else {
                    avgNighly += info.getMain().getTemp();
                }
                avgPressure += info.getMain().getPressure();

                count++;
            }
        }
        return WeatherForecastMetrics
                .builder()
                .averagePressure(avgPressure/count)
                .averageTemperatureDay(avgDaily/(count/2))
                .averageTemperatureNight(avgNighly/(count/2))
                .build();
    }

    private boolean isValidDateInterval(LocalDate forecastDate) {
        logger.debug("isValidDateInterval: {}", forecastDate);
        LocalDate today = LocalDate.now(ZoneId.of("UTC"));
        if (forecastDate.isAfter(today) && forecastDate.isBefore(today.plusDays(4))) {
            return true;
        }
        return false;
    }

    private boolean isDaily(LocalTime forecastTime) {
        logger.debug("isDaily: {}", forecastTime);
        if (forecastTime.getHour() >= 6 && forecastTime.getHour() < 18) {
            return true;
        }
        return false;
    }


}
