package com.lasiqueira.weatherforecast.api.exception.v1;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(String message) {
        super(message);
    }
}
