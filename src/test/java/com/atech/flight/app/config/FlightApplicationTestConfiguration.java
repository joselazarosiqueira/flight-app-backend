package com.atech.flight.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class to inject spring context for tests.
 * 
 * @author José Júnior <joselazarosiqueira@gmail.com>
 */
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@EnableTransactionManagement
@EntityScan(basePackages = {"com.atech.flight.app.model"})
@ComponentScan(basePackages = {"com.atech.flight.app.controller",
        "com.atech.flight.app.service"})
@EnableJpaRepositories(basePackages = {"com.atech.flight.app.repository"})
public class FlightApplicationTestConfiguration {

}
