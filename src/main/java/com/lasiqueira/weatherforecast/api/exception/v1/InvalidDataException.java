package com.lasiqueira.weatherforecast.api.exception.v1;

public class InvalidDataException extends Throwable {
    public InvalidDataException(String message) {
        super(message);
    }
}
