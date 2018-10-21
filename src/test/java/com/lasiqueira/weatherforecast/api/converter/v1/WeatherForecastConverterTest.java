package com.lasiqueira.weatherforecast.api.converter.v1;


import com.lasiqueira.weatherforecast.api.dto.v1.WeatherForecastMetricsDTO;
import com.lasiqueira.weatherforecast.model.WeatherForecastMetrics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastConverterTest {
    @Autowired
    private WeatherForecastConverter weatherForecastConverter;

    private WeatherForecastMetrics weatherForecastMetrics;

    @Before
    public void setup(){
        weatherForecastMetrics = random(WeatherForecastMetrics.class);
    }


    @Test
    public void convertModelToDTOTest(){
        WeatherForecastMetricsDTO expected = weatherForecastConverter.convertModelToDTO(weatherForecastMetrics);

        assertNotNull(expected);
        assertEquals(expected.getAveragePressure(), weatherForecastMetrics.getAveragePressure());
        assertEquals(expected.getAverageTemperatureDay(), weatherForecastMetrics.getAverageTemperatureDay());
        assertEquals(expected.getAverageTemperatureNight(), weatherForecastMetrics.getAverageTemperatureNight());
    }
}
