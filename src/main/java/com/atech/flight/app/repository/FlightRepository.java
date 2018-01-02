package com.atech.flight.app.repository;

import com.atech.flight.app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Data Access Object for Flight Model
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
