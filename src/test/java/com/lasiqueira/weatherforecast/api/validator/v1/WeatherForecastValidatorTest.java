package com.lasiqueira.weatherforecast.api.validator.v1;

import com.lasiqueira.weatherforecast.api.exception.v1.CityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherForecastValidatorTest {
    @Autowired
    private WeatherForecastValidator weatherForecastValidator;

    private static final String CITY = "London";
    private static final String COUNTRY_CODE = "GB";

    @Test
    public void validateCityAndCountryTest() throws CityNotFoundException {
        Integer result = weatherForecastValidator.validateCityAndCountry(CITY, Optional.of(COUNTRY_CODE));

        assertNotNull(result);
    }

    @Test
    public void validateCityAndCountryInvalidTest() throws CityNotFoundException {
        Assertions.assertThrows(CityNotFoundException.class, () -> weatherForecastValidator.validateCityAndCountry("Test", Optional.of(COUNTRY_CODE)));

    }

    @Test
    public void validateCityAndCountryCityOnlyTest()   throws CityNotFoundException {
        Integer result = weatherForecastValidator.validateCityAndCountry(CITY, Optional.empty());

        assertNotNull(result);
    }

    @Test
    public void validateCityAndCountryCityOnlyInvalidTest()   throws CityNotFoundException {
        Assertions.assertThrows(CityNotFoundException.class, () -> weatherForecastValidator.validateCityAndCountry("ABCDEFGHIJ", Optional.empty()));
    }

    @Test
    public void validateCityAndCountryCityOnlyEmptyTest()   throws CityNotFoundException {
        Assertions.assertThrows(CityNotFoundException.class, () -> weatherForecastValidator.validateCityAndCountry("", Optional.empty()));
    }
}
