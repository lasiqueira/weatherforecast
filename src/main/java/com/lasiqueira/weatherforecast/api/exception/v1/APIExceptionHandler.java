package com.lasiqueira.weatherforecast.api.exception.v1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({InvalidDataException.class, JsonParseException.class, DateTimeParseException.class, InvalidFormatException.class, IOException.class, URISyntaxException.class, Exception.class})
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {

        if (ex.getCause() instanceof InvalidDataException) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity<>(new ApiError(ex.getMessage()), status);
        } else if (ex.getCause() instanceof JsonParseException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(new ApiError(ex.getMessage()), status);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(new ApiError(ex.getMessage()), status);
        }
    }

}
