package com.lasiqueira.weatherforecast.service;


import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import com.lasiqueira.weatherforecast.api.external.dto.openweather.Info;
import com.lasiqueira.weatherforecast.api.external.dto.openweather.Main;
import com.lasiqueira.weatherforecast.api.external.dto.openweather.OpenWeatherMapDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherForecastServiceTest {
    @Autowired
    private WeatherForecastService weatherForecastService;
    @MockBean
    private OpenWeatherMapAPI openWeatherMapAPI;
    @MockBean
    Call<OpenWeatherMapDTO> call;

    private OpenWeatherMapDTO openWeatherMapDTO;

    private static final int CITY_ID= 2643743;

    @BeforeAll
    public void setup(){
        openWeatherMapDTO = random(OpenWeatherMapDTO.class);
        openWeatherMapDTO.setInfo(new ArrayList<>());
        var info1 = new Info();
        var main1 = new Main();
        var info2 = new Info();
        var main2 = new Main();
        var info3 = new Info();
        var main3 = new Main();
        var info4 = new Info();
        var main4 = new Main();
        var info5 = new Info();
        var main5 = new Main();
        info1.setDtTxt(LocalDateTime.now(ZoneId.of("UTC")).plusDays(1).withHour(7));
        main1.setTemp(32.00);
        main1.setPressure(800.00);
        info1.setMain(main1);

        info2.setDtTxt(LocalDateTime.now(ZoneId.of("UTC")).plusDays(1).withHour(19));
        main2.setTemp(22.00);
        main2.setPressure(450.00);
        info2.setMain(main2);

        info3.setDtTxt(LocalDateTime.now(ZoneId.of("UTC")).plusDays(2).withHour(7));
        main3.setTemp(25.00);
        main3.setPressure(500.00);
        info3.setMain(main3);

        info4.setDtTxt(LocalDateTime.now(ZoneId.of("UTC")).plusDays(2).withHour(19));
        main4.setTemp(20.00);
        main4.setPressure(800.00);
        info4.setMain(main4);

        info5.setDtTxt(LocalDateTime.now(ZoneId.of("UTC")).plusDays(5).withHour(7));
        main5.setTemp(30.00);
        main5.setPressure(1000.00);
        info5.setMain(main5);
        openWeatherMapDTO.getInfo().add(info1);
        openWeatherMapDTO.getInfo().add(info2);
        openWeatherMapDTO.getInfo().add(info3);
        openWeatherMapDTO.getInfo().add(info4);
        openWeatherMapDTO.getInfo().add(info5);


    }


    @Test
    public void getWeatherForecastMetricsTest() throws IOException {
        when(openWeatherMapAPI.getWeather5Day(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).thenReturn(call);
        when(call.execute()).thenReturn(Response.success(openWeatherMapDTO));
        var result = weatherForecastService.getWeatherForecastMetrics(CITY_ID);
        assertNotNull(result);

        assertEquals(new BigDecimal("637.50"), result.getAveragePressure());
        assertEquals(new BigDecimal("28.50"),result.getAverageTemperatureDay());
        assertEquals(new BigDecimal("21.00"), result.getAverageTemperatureNight());
    }

    @Test
    public void getWeatherForecastMetricsExceptionTest() throws IOException {
        when(openWeatherMapAPI.getWeather5Day(Mockito.anyInt(), Mockito.anyString(), Mockito.anyString())).thenReturn(call);
        when(call.execute()).thenThrow(IOException.class);
        Assertions.assertThrows(IOException.class, () -> weatherForecastService.getWeatherForecastMetrics(CITY_ID));
    }


}
