package com.lasiqueira.weatherforecast.configuration;

import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class RetrofitConfiguration {

    @Bean
    public OpenWeatherMapAPI getOpenWeatherMapAPI(@Value("openweathermapurl") String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .build();

        return  retrofit.create(OpenWeatherMapAPI.class);


    }
}
