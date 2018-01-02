package com.atech.flight.app.controller;

import com.atech.flight.app.model.Flight;
import com.atech.flight.app.service.FlightService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Controller of all URLs for Flight Model
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@RestController
@RequestMapping(value = { "/flights" })
public class FlightController {

    private final static Logger log = Logger.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Flight>> getAll() {
        return new ResponseEntity<List<Flight>>(flightService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Flight> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<Flight>( flightService.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Flight> save(@RequestBody Flight flight) {
        Flight entity = flightService.save(flight);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Flight> update(@RequestBody Flight flight) {
        return new ResponseEntity<Flight>(flightService.update(flight), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        flightService.delete(id);
    }
}
