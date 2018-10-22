package com.lasiqueira.weatherforecast.api.validator.v1;

import com.lasiqueira.weatherforecast.api.exception.v1.CityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastValidatorTest {
    @Autowired
    private WeatherForecastValidator weatherForecastValidator;

    private static final String CITY = "London";
    private static final String COUNTRY_CODE = "GB";

    @Test
    public void validateCityAndCountryTest() throws CityNotFoundException {
        Integer expected = weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE));

        assertNotNull(expected);
    }

    @Test(expected = CityNotFoundException.class)
    public void validateCityAndCountryInvalidTest() throws CityNotFoundException {
        Integer expected = weatherForecastValidator.validateCityAndCountry("Test", Optional.of(COUNTRY_CODE));

    }

    @Test
    public void validateCityAndCountryCityOnlyTest()   throws CityNotFoundException {
        Integer expected = weatherForecastValidator.validateCityAndCountry(CITY, Optional.ofNullable(null));

        assertNotNull(expected);
    }

    @Test(expected = CityNotFoundException.class)
    public void validateCityAndCountryCityOnlyInvalidTest()   throws CityNotFoundException {
        Integer expected = weatherForecastValidator.validateCityAndCountry("ABCDEFGHIJ", Optional.ofNullable(null));
    }

    @Test(expected = CityNotFoundException.class)
    public void validateCityAndCountryCityOnlyEmptyTest()   throws CityNotFoundException {
        Integer expected = weatherForecastValidator.validateCityAndCountry("", Optional.ofNullable(null));
    }
}
