package com.atech.flight.app.model;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * Entity to manage Cities
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
@Entity
@Table(name = "tb_city")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City {

    private static final long serialVersionUID = -276371808887778468L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private String country;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}