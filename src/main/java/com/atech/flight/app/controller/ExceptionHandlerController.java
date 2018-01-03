package com.atech.flight.app.controller;

import com.atech.flight.app.api.error.ApiError;
import com.atech.flight.app.business.exception.FlightException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

/**
 * The Expcetion Handler for all Flight Endpoints
 *
 * @author  José Júnior <joselazarosiqueira@gmail.com>
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ApiError flightNotFoundException(EntityNotFoundException e){
        ApiError error = new ApiError(ApiErrorCodeFlight.COMMON_0000);
        error.setErrorMessage(e.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = FlightException.class)
    public ApiError flightException(FlightException e){
        ApiError error = new ApiError(ApiErrorCodeFlight.FLIGHT_0000);
        error.setErrorMessage(e.getMessage());
        return error;
    }
}
