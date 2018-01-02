package com.atech.flight.app.service;

import com.atech.flight.app.model.Airplane;
import com.atech.flight.app.repository.AirplaneRepository;
import com.atech.flight.app.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The implementation of AirplaneService
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Service
@Transactional
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public Airplane save(Airplane entity) {
        return airplaneRepository.save(entity);
    }

    @Override
    public Airplane update(Airplane entity) {
        Airplane entityFromDB = airplaneRepository.findOne(entity.getId());

        if (entityFromDB == null) {
            throw new EntityNotFoundException("[id:" + entity.getId() + "]");
        }
        BeanUtil.copyNonNullProperties(entity, entityFromDB);
        airplaneRepository.save(entityFromDB);
        entity = entityFromDB;

        return entity;
    }

    @Override
    public void delete(Long id) {
        airplaneRepository.delete(id);
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane findOne(Long id) {
        return airplaneRepository.findOne(id);
    }
}
