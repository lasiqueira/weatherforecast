package com.lasiqueira.weatherforecast.configuration;

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
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return  retrofit.create(OpenWeatherMapAPI.class);


    }
}
