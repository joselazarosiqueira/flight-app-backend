package com.atech.flight.app.controller;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.atech.flight.app.config.FlightApplicationTestConfiguration;
import com.atech.flight.app.model.Flight;
import com.atech.flight.app.service.FlightService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests of {@link FlightController}
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlightApplicationTestConfiguration.class})
@AutoConfigureMockMvc
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FlightControllerTest{
    
    @Autowired
    private FlightService service;

    private static String OBJECT_TO_SAVE = "object-to-save";
    private static String OBJECT_TO_UPDATE = "object-to-update";
    private static String OBJECT_NOT_EXISTS = "object-not-exists";

    @Autowired
    protected MockMvc mockMvc;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("com.atech.flight.app.templates.flight");
    }

    @Before
    public void setup() {

    }

    @Test
    public void saveObjectAndShouldReturnStatusOk() throws Exception {
        Flight entity = from(Flight.class).gimme(OBJECT_TO_SAVE);

        String contentToPost = new ObjectMapper().writeValueAsString(entity);

        MvcResult mvcResult =  this.mockMvc.perform(post(getUrl())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(contentToPost))
                .andExpect(status().isOk())
                .andReturn();

        String responseOfTheRequest = mvcResult.getResponse().getContentAsString();
        Flight entityReturned = new ObjectMapper().readValue(responseOfTheRequest, Flight.class);
        assertTrue(entity.equals(entityReturned));
    }

    @Test
    public void updateObjectAndShouldReturnStatusOk() throws Exception {
        Flight entity = from(Flight.class).gimme(OBJECT_TO_SAVE);
        service.save(entity);

        Flight entityToUpdate = from(Flight.class).gimme(OBJECT_TO_UPDATE);
        String contentToPost = new ObjectMapper().writeValueAsString(entityToUpdate);

        MvcResult mvcResult =  this.mockMvc.perform(put(getUrl())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(contentToPost))
                .andExpect(status().isOk())
                .andReturn();

        String responseOfTheRequest = mvcResult.getResponse().getContentAsString();
        Flight entityReturned = new ObjectMapper().readValue(responseOfTheRequest, Flight.class);
        assertTrue(entityToUpdate.equals(entityReturned));
    }

    @Test
    public void getOneObjectAndShouldReturnStatusOk() throws Exception {
        Flight entity = from(Flight.class).gimme(OBJECT_TO_SAVE);
        entity = service.save(entity);

        MvcResult mvcResult = this.mockMvc.perform(get(getUrl() + "/" + entity.getId()))
                .andExpect(status().isOk())
                .andReturn();
        String responseOfTheRequest = mvcResult.getResponse().getContentAsString();
        assertTrue(entity.equals(new ObjectMapper().readValue(responseOfTheRequest, Flight.class)));
    }

    @Test
    public void returnConflictWhenObjectNotFound() throws Exception {

        Flight entity = from(Flight.class).gimme(OBJECT_NOT_EXISTS);
        String contentToPost = new ObjectMapper().writeValueAsString(entity);

        this.mockMvc.perform(put(getUrl())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(contentToPost))
                .andExpect(status().isConflict())
                .andReturn();

        this.mockMvc.perform(get(getUrl() + "/50"))
                .andExpect(status().isConflict());
    }

    @Test
    public void deleteObjectAndShouldReturnStatusOk() throws Exception {
        Flight entity = service.save(from(Flight.class).gimme(OBJECT_TO_SAVE));
        MvcResult mvcResult = this.mockMvc.perform(delete(getUrl() + "/" + entity.getId()))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getAllObjectsInDatabase() throws Exception {
        List<Flight> entities = from(Flight.class).gimme(2, OBJECT_TO_SAVE);

        for (Flight entity: entities) {
            service.save(entity);
        }

        MvcResult mvcResult = this.mockMvc.perform(get(getUrl())).andExpect(status().isOk()).andReturn();

        String responseOfTheRequest = mvcResult.getResponse().getContentAsString();
        List<Flight> entitiesFromRequest = new ObjectMapper().readValue(responseOfTheRequest,
                new TypeReference<List<Flight>>() {});

        assertTrue(entitiesFromRequest.size() == 2);
    }


    private String getUrl() {
        return "/flights";
    }
}
