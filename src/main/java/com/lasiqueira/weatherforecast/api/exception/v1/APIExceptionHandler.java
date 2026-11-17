package com.lasiqueira.weatherforecast.api.exception.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class) public ResponseEntity < ApiError > notFoundException(final CityNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND);
    }

    // Also covers JSON parse errors (they are IOExceptions). Requests carry no JSON body, so those can only
    // come from OpenWeatherMap's response: a server-side failure rather than a 400.
    @ExceptionHandler(IOException.class) public ResponseEntity < ApiError > ioException(final IOException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(URISyntaxException.class) public ResponseEntity < ApiError > uriException(final URISyntaxException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity <ApiError> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.ofNullable(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity < > (new ApiError(message), httpStatus);
    }

}
