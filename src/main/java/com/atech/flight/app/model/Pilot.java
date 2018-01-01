package com.atech.flight.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entity to manage Pilot
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
@Entity
@Table(name = "tb_pilot")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pilot {

    private static final long serialVersionUID = -996371808887778468L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "pilot", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.REFRESH})
    private List<Flight> flights = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}