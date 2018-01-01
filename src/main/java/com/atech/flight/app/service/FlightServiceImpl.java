package com.atech.flight.app.service;

import com.atech.flight.app.model.Flight;
import com.atech.flight.app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The implementation of FlightService
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return null;
    }

    @Override
    public void delete(Long id) {
        flightRepository.delete(id);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findOne(Long id) {
        return flightRepository.findOne(id);
    }
}
