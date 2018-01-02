package com.atech.flight.app.model;

import com.atech.flight.app.utils.LocalDateTimeAttributeConverter;
import com.atech.flight.app.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity to manage Flights
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Entity
@Table(name = "tb_flight")
@JsonInclude(Include.NON_NULL)
public class Flight {

    private static final long serialVersionUID = -276371808887778468L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private City to;
    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private City from;

    @Column(name = "departure_date_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime departureDateTime;
    @Column(name = "arrival_date_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime arrivalDateTime;

    @Enumerated(value = EnumType.STRING)
    private FlightStatus status;

    @ManyToOne
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return flightNumber != null ? flightNumber.equals(flight.flightNumber) : flight.flightNumber == null;
    }

    @Override
    public int hashCode() {
        return flightNumber.hashCode();
    }
}
