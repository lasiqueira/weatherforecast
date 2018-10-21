package com.lasiqueira.weatherforecast.api.exception.v1;

public class CityNotFoundException extends Throwable {
    public CityNotFoundException(String message) {
        super(message);
    }
}
