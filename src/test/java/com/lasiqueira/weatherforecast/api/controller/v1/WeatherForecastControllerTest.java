package com.lasiqueira.weatherforecast.api.controller.v1;

import com.fasterxml.jackson.core.JsonParseException;
import com.lasiqueira.weatherforecast.api.converter.v1.WeatherForecastConverter;
import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.api.exception.v1.CityNotFoundException;
import com.lasiqueira.weatherforecast.api.validator.v1.WeatherForecastValidator;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import com.lasiqueira.weatherforecast.service.WeatherForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.cache.test.autoconfigure.AutoConfigureCache;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherForecastController.class)
@AutoConfigureCache // no longer implied by @WebMvcTest in Boot 4; needed because Application has @EnableCaching
class WeatherForecastControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private WeatherForecastValidator weatherForecastValidator;
    @MockitoBean
    private WeatherForecastService weatherForecastService;
    @MockitoBean
    private WeatherForecastConverter weatherForecastConverter;

    private static final String CITY = "London";
    private static final String INVALID_CITY = "Londonnnnn";
    private static final String COUNTRY_CODE = "GB";
    private static final int CITY_ID = 2643743;

    private final WeatherForecastMetrics weatherForecastMetrics =
            new WeatherForecastMetrics(BigDecimal.valueOf(18.0), BigDecimal.valueOf(10.10), BigDecimal.valueOf(54.38));
    private final WeatherForecastMetricsDTO weatherForecastMetricsDTO = new WeatherForecastMetricsDTO(
            weatherForecastMetrics.averageTemperatureDay(),
            weatherForecastMetrics.averageTemperatureNight(),
            weatherForecastMetrics.averagePressure());

    @BeforeEach
    void setup() throws IOException {
        when(weatherForecastService.getWeatherForecastMetrics(CITY_ID)).thenReturn(weatherForecastMetrics);
        when(weatherForecastConverter.convertModelToDTO(weatherForecastMetrics)).thenReturn(weatherForecastMetricsDTO);
    }

    @Test
    void getWeatherForecastByCityTest() throws Exception {
        when(weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE))).thenReturn(CITY_ID);

        mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, CITY))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.averageTemperatureDay").value(18.0))
                .andExpect(jsonPath("$.averageTemperatureNight").value(10.1))
                .andExpect(jsonPath("$.averagePressure").value(54.38));
    }

    @Test
    void getWeatherForecastByCityNotFoundTest() throws Exception {
        when(weatherForecastValidator.validateCityAndCountry(INVALID_CITY, Optional.of(COUNTRY_CODE)))
                .thenThrow(new CityNotFoundException("City not found."));

        mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, INVALID_CITY))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMsg").value("City not found."));
        verify(weatherForecastService, never()).getWeatherForecastMetrics(anyInt());
    }

    @Test
    void getWeatherForecastByCityWrongUrlTest() throws Exception {
        mockMvc.perform(get("/v1/data/cities"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getWeatherForecastByCityServerErrorTest() throws Exception {
        when(weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE))).thenReturn(CITY_ID);
        when(weatherForecastService.getWeatherForecastMetrics(CITY_ID)).thenThrow(new IOException("upstream failed"));

        mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, CITY))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorMsg").value("upstream failed"));
    }

    @Test
    void getWeatherForecastUnparseableUpstreamResponseTest() throws Exception {
        // The request carries no JSON body, so a parse error can only come from OpenWeatherMap's response:
        // that's a server-side failure, not a bad request.
        when(weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE))).thenReturn(CITY_ID);
        when(weatherForecastService.getWeatherForecastMetrics(CITY_ID))
                .thenThrow(new JsonParseException(null, "Unexpected character"));

        mockMvc.perform(get("/v1/data/countries/{countryCode}/cities/{city}", COUNTRY_CODE, CITY))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getWeatherForecastByCityQueryTest() throws Exception {
        when(weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE))).thenReturn(CITY_ID);

        mockMvc.perform(get("/v1/data").param("city", CITY + ", " + COUNTRY_CODE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.averagePressure").value(54.38));
    }

    @Test
    void getWeatherForecastByCityQueryErrorTest() throws Exception {
        mockMvc.perform(get("/v1/data"))
                .andExpect(status().isBadRequest());
        verify(weatherForecastValidator, never()).validateCityAndCountry(anyString(), any());
    }

    @Test
    void getWeatherForecastByCityQueryCityOnlyTest() throws Exception {
        when(weatherForecastValidator.validateCityAndCountry(CITY, Optional.empty())).thenReturn(CITY_ID);

        mockMvc.perform(get("/v1/data").param("city", CITY))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.averageTemperatureDay").value(18.0));
    }
}
