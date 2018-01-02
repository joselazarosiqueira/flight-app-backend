package com.atech.flight.app.service;

import com.atech.flight.app.model.Flight;
import com.atech.flight.app.repository.FlightRepository;
import com.atech.flight.app.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The implementation of FlightService
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private PilotService pilotService;

    @Override
    public Flight save(Flight entity) {
        //saves Airplane
        if(entity.getAirplane() != null) {
            entity.setAirplane(airplaneService.save(entity.getAirplane()));
        }

        //saves from City
        if(entity.getFrom() != null) {
            entity.setFrom(cityService.save(entity.getFrom()));
        }

        //saves to City
        if(entity.getTo() != null) {
            entity.setTo(cityService.save(entity.getTo()));
        }

        //saves Pilot
        if(entity.getPilot() != null) {
            entity.setPilot(pilotService.save(entity.getPilot()));
        }

        return flightRepository.save(entity);
    }

    @Override
    public Flight update(Flight entity) {
        Flight entityFromDB = flightRepository.findOne(entity.getId());

        if (entityFromDB == null) {
            throw new EntityNotFoundException("[id:" + entity.getId() + "]");
        }
        BeanUtil.copyNonNullProperties(entity, entityFromDB);
        this.save(entityFromDB);
        entity = entityFromDB;

        return entity;
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
