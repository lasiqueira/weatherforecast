package com.lasiqueira.weatherforecast.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration {

    @Bean
    public OkHttpClient getOkHttpClient(@Value("${client.readtimeout}") final int readTimout, @Value("${client.connecttimeout}") final int connectTimeout) {
             return new OkHttpClient.Builder()
                .readTimeout(readTimout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public OpenWeatherMapAPI getOpenWeatherMapAPI(@Value("${openweathermap.url}") String url, OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                // Retrofit's converter uses Jackson 2; ignore fields OpenWeatherMap added after the DTOs were written
                .addConverterFactory(JacksonConverterFactory.create(
                        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
                .client(okHttpClient)
                .build();

        return  retrofit.create(OpenWeatherMapAPI.class);
    }
}
