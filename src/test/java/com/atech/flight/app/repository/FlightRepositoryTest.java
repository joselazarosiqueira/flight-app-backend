package com.atech.flight.app.repository;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.atech.flight.app.config.FlightApplicationTestConfiguration;
import com.atech.flight.app.model.Flight;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.atech.flight.app.templates.flight.FlightTemplateLoader.TO_SAVE;
import static com.atech.flight.app.templates.flight.FlightTemplateLoader.TO_UPDATE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Repository tests of {@link FlightRepository}
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightApplicationTestConfiguration.class)
@DataJpaTest
public class FlightRepositoryTest {
    private static final int TOTAL_FLIGHTS = 3;

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private TestEntityManager entityManager;

    private static List<Flight> flights;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("com.atech.flight.app.templates.flight");
    }

    @Before
    public void init() {
        flights = from(Flight.class).gimme(TOTAL_FLIGHTS, TO_SAVE);
        flights.forEach(company -> entityManager.persist(company));
    }

    @Test
    public void findAll() {
        List<Flight> flightsFromRepository = flightRepository.findAll();

        assertEquals(TOTAL_FLIGHTS, flightsFromRepository.size());
        assertTrue(flightsFromRepository.containsAll(flights));
    }

    @Test
    public void delete() {
        long id = 1L;
        flightRepository.delete(id);
        assertEquals(TOTAL_FLIGHTS - 1, flightRepository.findAll().size());
        assertEquals(null, flightRepository.findOne(id));
    }

    @Test
    public void save() {
        long id = 1L;
        flightRepository.deleteAll();
        Flight flight = from(Flight.class).gimme(TO_UPDATE);
        Flight flightFromRepository = flightRepository.save(flight);
        assertEquals(1, flightRepository.findAll().size());
        assertEquals(flight, flightFromRepository);
    }
}
