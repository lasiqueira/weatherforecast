package com.lasiqueira.weatherforecast.api.exception.v1;

import com.fasterxml.jackson.core.JsonParseException;
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

    @ExceptionHandler(JsonParseException.class) public ResponseEntity < ApiError > jsonParseException(final JsonParseException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IOException.class) public ResponseEntity < ApiError > ioException(final IOException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(URISyntaxException.class) public ResponseEntity < ApiError > uriException(final URISyntaxException e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity <ApiError> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity < > (new ApiError(message), httpStatus);
    }

}
