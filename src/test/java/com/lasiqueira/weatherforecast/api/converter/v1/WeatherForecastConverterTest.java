package com.lasiqueira.weatherforecast.api.converter.v1;


import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
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
        weatherForecastMetrics = random(WeatherForecastMetrics.class);
    }


    @Test
    public void convertModelToDTOTest(){
        WeatherForecastMetricsDTO result = weatherForecastConverter.convertModelToDTO(weatherForecastMetrics);

        assertNotNull(result);
        assertEquals(weatherForecastMetrics.getAveragePressure(),result.getAveragePressure());
        assertEquals(weatherForecastMetrics.getAverageTemperatureDay(), result.getAverageTemperatureDay());
        assertEquals(weatherForecastMetrics.getAverageTemperatureNight(), result.getAverageTemperatureNight());
    }
}
