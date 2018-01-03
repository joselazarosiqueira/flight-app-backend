# Flight-app-backend

This is a Spring Boot Application to manage simple Flights

## Requirements
In order to run the application you need to configure the following items:

-PostgreSQL datasource:

1) using dev profile:
 db_dev_atech database and sc_flight schema

2) using test profile:
 db_test_atech database and sc_flight schema

## Run
mvn spring-boot:run -Dspring.profiles.active=dev

## Build

mvn clean install

## Running tests

mvn test

## Further help

Please contact the author: joselazarosiqueira@gmail.com

## ER Model
![Screenshot](https://gitlab.com/joselazaro/flight-app-backend/blob/afb5cff5035c4c7b30d3b2faeb4d53892137f529/ER-model.png)