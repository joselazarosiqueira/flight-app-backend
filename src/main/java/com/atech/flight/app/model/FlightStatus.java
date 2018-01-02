package com.atech.flight.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status type of a Flight
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
public enum FlightStatus {
    @JsonProperty
    WAITING,
    @JsonProperty
    FLYING,
    @JsonProperty
    LANDED,
    @JsonProperty
    CANCELLED,
    @JsonProperty
    DELAYED;

    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

