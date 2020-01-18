package com.lasiqueira.weatherforecast.api.external.client;

import com.lasiqueira.weatherforecast.api.external.dto.openweather.OpenWeatherMapDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapAPI {

    @GET("data/2.5/forecast")
    Call<OpenWeatherMapDTO> getWeather5Day(@Query("id") final Integer cityId, @Query("units") final String unit, @Query("APPID") final String apiKey);
}
