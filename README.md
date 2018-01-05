# Flight-app-backend

This is a Spring Boot Application to manage simple Flights

## Requirements
In order to run the application you need to configure the following items:

-PostgreSQL datasource:

1) using dev profile:
 db_dev_atech database and sc_flight schema

2) using test profile:
 db_test_atech database and sc_flight schema

## Build

mvn clean install

## Run
mvn spring-boot:run -Dspring.profiles.active=dev

## Running tests

mvn test

## Further help

Please contact the author: joselazarosiqueira@gmail.com

## ER Model
![Screenshot](https://github.com/joselazarosiqueira/flight-app-backend/blob/master/ER-model.png)
