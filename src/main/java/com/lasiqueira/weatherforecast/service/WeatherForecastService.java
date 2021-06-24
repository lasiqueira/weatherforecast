package com.lasiqueira.weatherforecast.service;

import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import com.lasiqueira.weatherforecast.api.external.dto.openweather.Info;
import com.lasiqueira.weatherforecast.api.external.dto.openweather.OpenWeatherMapDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = {"weatherforecast"})
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

    @Cacheable(key = "#cityId")
    public WeatherForecastMetrics getWeatherForecastMetrics(Integer cityId) throws IOException {
        logger.debug("getWeatherForecastMetrics: {}", cityId);
        var openWeatherMapDTO = getWeatherForecast(cityId);
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

        var validMetrics = infoList.stream()
                .filter(info -> isValidDateInterval(info.getDtTxt().toLocalDate()))
                .collect(Collectors.toList());
        var dailyMetrics = validMetrics.stream()
                .filter(info -> isDaily(info.getDtTxt().toLocalTime()))
                .collect(Collectors.toList());
        var nightlyMetrics = validMetrics.stream()
                .filter(info -> !isDaily(info.getDtTxt().toLocalTime()))
                .collect(Collectors.toList());

        return new WeatherForecastMetrics(getDailyAverage(dailyMetrics), getNightlyAverage(nightlyMetrics), getPressureAverage(validMetrics));
    }

    private boolean isValidDateInterval(LocalDate forecastDate) {
        logger.debug("isValidDateInterval: {}", forecastDate);
        var today = LocalDate.now(ZoneId.of("UTC"));
        return forecastDate.isAfter(today) && forecastDate.isBefore(today.plusDays(4));
    }

    private boolean isDaily(LocalTime forecastTime) {
        logger.debug("isDaily: {}", forecastTime);
        return forecastTime.getHour() >= 6 && forecastTime.getHour() < 18;
    }

    private BigDecimal getDailyAverage(List<Info> infoList) {
        var avgDaily = new BigDecimal("0.00");
        return avgDaily.add(BigDecimal.valueOf(
                infoList.stream()
                        .mapToDouble(info -> info.getMain().getTemp())
                        .average()
                        .orElse(0.0)));
    }

    private BigDecimal getNightlyAverage(List<Info> infoList) {
        var avgNighly = new BigDecimal("0.00");
        return avgNighly.add(BigDecimal.valueOf(
                infoList.stream()
                        .mapToDouble(info -> info.getMain().getTemp())
                        .average()
                        .orElse(0.0)));
    }

    private BigDecimal getPressureAverage(List<Info> infoList) {
        var avgPressure = new BigDecimal("0.00");
        return avgPressure.add(BigDecimal.valueOf(
                infoList.stream()
                        .mapToDouble(info -> info.getMain().getPressure())
                        .average()
                        .orElse(0.0)));
    }
}
