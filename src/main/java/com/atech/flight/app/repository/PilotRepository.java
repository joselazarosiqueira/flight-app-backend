package com.atech.flight.app.repository;

import com.atech.flight.app.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Data Access Object for Pilot Model
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
