package com.lasiqueira.weatherforecast.api.controller.v1;

import com.lasiqueira.weatherforecast.api.converter.v1.WeatherForecastConverter;
import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.api.exception.v1.CityNotFoundException;
import com.lasiqueira.weatherforecast.api.validator.v1.WeatherForecastValidator;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import com.lasiqueira.weatherforecast.service.WeatherForecastService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Optional;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherForecastController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherForecastControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherForecastValidator weatherForecastValidator;
    @MockBean
    private WeatherForecastService weatherForecastService;
    @MockBean
    private WeatherForecastConverter weatherForecastConverter;

    private static final String CITY = "London";
    private static final String INVALID_CITY = "Londonnnnn";
    private static final String COUNTRY_CODE = "GB";

    private static final int CITY_ID = 2643743;

    private WeatherForecastMetrics weatherForecastMetrics;
    private WeatherForecastMetricsDTO weatherForecastMetricsDTO;

    @BeforeAll
    public void setup(){
        weatherForecastMetrics = random(WeatherForecastMetrics.class);
        weatherForecastMetricsDTO = new WeatherForecastMetricsDTO(
                weatherForecastMetrics.getAverageTemperatureDay(),
                weatherForecastMetrics.getAverageTemperatureNight(),
                weatherForecastMetrics.getAveragePressure()
        );
    }

    @Test
    public void getWeatherForecastByCityTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, CITY))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWeatherForecastByCityNotFoundTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(INVALID_CITY, Optional.of(COUNTRY_CODE))).thenThrow(new CityNotFoundException("City not found."));
        try {
            mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, INVALID_CITY))
                    .andExpect(status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWeatherForecastByCityWrongUrlTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data/cities"))
                    .andExpect(status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWeatherForecastByCityServerErrorTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenThrow(IOException.class);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data/cities"))
                    .andExpect(status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getWeatherForecastByCityQueryTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data")
            .param("city", CITY + ", " + COUNTRY_CODE))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWeatherForecastByCityQueryErrorTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getWeatherForecastByCityQueryCityOnlyTest() throws IOException, CityNotFoundException {
        when(weatherForecastService.getWeatherForecastMetrics(Mockito.anyInt())).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(Mockito.any(WeatherForecastMetrics.class))).thenReturn(weatherForecastMetricsDTO);
        when(weatherForecastValidator.validateCityAndCountry(Mockito.anyString(), Optional.of(Mockito.anyString()))).thenReturn(CITY_ID);
        try {
            mockMvc.perform(get("/v1/data")
                    .param("city"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
