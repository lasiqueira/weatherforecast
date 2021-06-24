package com.lasiqueira.weatherforecast.api.converter.v1;


import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherForecastConverterTest {
    @Autowired
    private WeatherForecastConverter weatherForecastConverter;

    private WeatherForecastMetrics weatherForecastMetrics;

    @BeforeAll
    public void setup(){
        weatherForecastMetrics = new WeatherForecastMetrics(BigDecimal.valueOf(19.02), BigDecimal.valueOf(12.23), BigDecimal.valueOf(160.12));
    }


    @Test
    public void convertModelToDTOTest(){
        var result = weatherForecastConverter.convertModelToDTO(weatherForecastMetrics);

        assertNotNull(result);
        assertEquals(weatherForecastMetrics.averagePressure(),result.averagePressure());
        assertEquals(weatherForecastMetrics.averageTemperatureDay(), result.averageTemperatureDay());
        assertEquals(weatherForecastMetrics.averageTemperatureNight(), result.averageTemperatureNight());
    }
}
