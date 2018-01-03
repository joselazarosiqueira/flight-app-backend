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
     * COMMON-0000 Entity not found
     */
    COMMON_0000("COMMON-0000", "Entity not found.");

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
