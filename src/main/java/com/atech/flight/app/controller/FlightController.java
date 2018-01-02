package com.atech.flight.app.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Controller of all URLs for Flight Model
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@RestController
@RequestMapping(value = { "/flights" })
public class FlightController {

    private final static Logger log = Logger.getLogger(FlightController.class);


}
