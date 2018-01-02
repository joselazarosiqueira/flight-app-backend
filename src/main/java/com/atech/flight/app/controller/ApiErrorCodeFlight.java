package com.atech.flight.app.controller;

import com.atech.flight.app.api.error.ApiErrorCode;

/**
 * The API Error Code for all Flight Endpoints
 *
 * @author  José Júnior <joselazarosiqueira@gmail.com>
 */
public enum ApiErrorCodeFlight implements ApiErrorCode {

    /**
     * FLIGHT-0000 Unexpected error.
     */
    FLIGHT_0000("FLIGHT-0000", "Unexpected error."),
    /**
     * FLIGHT-0001 Example of message
     */
    FLIGHT_0001("FLIGHT-0001", "Flight does not exists.");

    private String code;
    private String message;

    private ApiErrorCodeFlight(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
