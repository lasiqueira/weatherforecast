package com.lasiqueira.weatherforecast.configuration;

import com.lasiqueira.weatherforecast.api.external.client.OpenWeatherMapAPI;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Checks that the Retrofit client (Jackson 2 converter) deserializes a payload in the current
 * OpenWeatherMap 5 day / 3 hour forecast format, which has fields the DTOs don't map.
 */
public class RetrofitConfigurationTest {

    private static final String PAYLOAD = """
            {"cod":"200","message":0,"cnt":1,
             "list":[{"dt":1661871600,
                      "main":{"temp":296.76,"feels_like":296.98,"temp_min":296.76,"temp_max":297.87,"pressure":1015,
                              "sea_level":1015,"grnd_level":933,"humidity":69,"temp_kf":-1.11},
                      "weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],
                      "clouds":{"all":100},"wind":{"speed":0.62,"deg":349,"gust":1.18},"visibility":10000,"pop":0.32,
                      "rain":{"3h":0.26},"sys":{"pod":"d"},"dt_txt":"2022-08-30 15:00:00"}],
             "city":{"id":3163858,"name":"Zocca","coord":{"lat":44.34,"lon":10.99},"country":"IT","population":4593,
                     "timezone":7200,"sunrise":1661834187,"sunset":1661882248}}
            """;

    @Test
    public void deserializesCurrentForecastFormat() throws IOException {
        var okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> new Response.Builder()
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .message("OK")
                        .body(ResponseBody.create(PAYLOAD, MediaType.get("application/json")))
                        .build())
                .build();
        OpenWeatherMapAPI api = new RetrofitConfiguration().getOpenWeatherMapAPI("http://localhost/", okHttpClient);

        var response = api.getWeather5Day(3163858, "metric", "key").execute();

        assertTrue(response.isSuccessful());
        var info = response.body().getInfo().getFirst();
        assertEquals(LocalDateTime.of(2022, 8, 30, 15, 0), info.getDtTxt());
        assertEquals(296.76, info.getMain().getTemp());
        assertEquals(1015.0, info.getMain().getPressure());
        assertEquals("Zocca", response.body().getCity().getName());
    }
}
