package com.lasiqueira.weatherforecast.api.validator.v1;

import com.lasiqueira.weatherforecast.api.exception.v1.InvalidDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastValidatorTest {
    @Autowired
    private WeatherForecastValidator weatherForecastValidator;

    private static final String city = "London";
    private static final String countryCode = "GB";

    @Test
    public void validateCityAndCountryTest() throws InvalidDataException {
        Integer expected = weatherForecastValidator.validateCityAndCountry(city, countryCode);

        assertNotNull(expected);
    }

    @Test(expected =InvalidDataException.class)
    public void validateCityAndCountryInvalidTest() throws InvalidDataException {
        Integer expected = weatherForecastValidator.validateCityAndCountry("Test", countryCode);

    }
}
