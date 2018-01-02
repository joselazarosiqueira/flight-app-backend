package com.atech.flight.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity to manage Airplanes
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Entity
@Table(name = "tb_airplane")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Airplane {

    private static final long serialVersionUID = -576371808887778468L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long capacity;

    @Column(name = "model_number", nullable = false)
    private String modelNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.REFRESH})
    private List<Flight> flights = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}