package com.atech.flight.app.service;

import com.atech.flight.app.model.City;
import com.atech.flight.app.repository.CityRepository;
import com.atech.flight.app.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The implementation of CityService
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City entity) {
        return cityRepository.save(entity);
    }

    @Override
    public City update(City entity) {
        City entityFromDB = cityRepository.findOne(entity.getId());

        if (entityFromDB == null) {
            throw new EntityNotFoundException("[id:" + entity.getId() + "]");
        }
        BeanUtil.copyNonNullProperties(entity, entityFromDB);
        cityRepository.save(entityFromDB);
        entity = entityFromDB;

        return entity;
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findOne(Long id) {
        return cityRepository.findOne(id);
    }
}
