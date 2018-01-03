package com.atech.flight.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuration class to inject spring context.
 *
 * @author José Júnior <joselazarosiqueira@gmail.com>
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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/flights/**").allowedOrigins("*");
            }
        };
    }

}
