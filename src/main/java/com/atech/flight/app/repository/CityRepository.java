package com.atech.flight.app.repository;

import com.atech.flight.app.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Data Access Object for City Model
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
