package com.atech.flight.app.repository;

import com.atech.flight.app.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Data Access Object for Airplane Model
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
