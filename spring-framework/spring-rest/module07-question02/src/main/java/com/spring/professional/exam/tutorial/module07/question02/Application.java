package com.spring.professional.exam.tutorial.module07.question02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // Visit http://localhost:8080/ in browser to navigate through REST Service
    // curl -X GET http://localhost:8080/customers |jq
    // curl -X GET http://localhost:8080/customers/1 |jq
    // curl -X GET http://localhost:8080/customers/1/addresses |jq
    // curl -X GET http://localhost:8080/customers/1/addresses/1 |jq
    // curl -X POST -H 'Content-Type: application/json' -d '{ "addressName": "Apartment Address", "streetNumber": 3551, "streetName": "Maple Lane", "aptNumber": 4, "city": "Huntsville", "state": "AL", "zipCode": "35816" }' http://localhost:8080/addresses |jq
    // curl -i -X PUT -H "Content-Type: text/uri-list" -d 'http://localhost:8080/customers/1' http://localhost:8080/addresses/7/customer
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
