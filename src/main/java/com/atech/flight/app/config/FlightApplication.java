package com.atech.flight.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class to inject spring context.
 *
 * @author José Júnior <jose.junior@jetsoft.com.br>
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.atech.flight.app.model"})
@ComponentScan(basePackages = {"com.atech.flight.app.controller",
        "com.atech.flight.app.service"})
@EnableJpaRepositories(basePackages = {"com.atech.flight.app.repository"})
public class FlightApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightApplication.class, args);
    }

}
