package com.atech.flight.app.service;

import com.atech.flight.app.model.Pilot;
import com.atech.flight.app.repository.PilotRepository;
import com.atech.flight.app.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The implementation of PilotService
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public Pilot save(Pilot entity) {
        return pilotRepository.save(entity);
    }

    @Override
    public Pilot update(Pilot entity) {
        Pilot entityFromDB = pilotRepository.findOne(entity.getId());

        if (entityFromDB == null) {
            throw new EntityNotFoundException("[id:" + entity.getId() + "]");
        }
        BeanUtil.copyNonNullProperties(entity, entityFromDB);
        pilotRepository.save(entityFromDB);
        entity = entityFromDB;

        return entity;
    }

    @Override
    public void delete(Long id) {
        pilotRepository.delete(id);
    }

    @Override
    public List<Pilot> findAll() {
        return pilotRepository.findAll();
    }

    @Override
    public Pilot findOne(Long id) {
        return pilotRepository.findOne(id);
    }
}
