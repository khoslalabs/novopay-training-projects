package com.spring.professional.exam.tutorial.module07.question07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // Read:
    // curl -H "Accept: application/json" http://localhost:8080/customers |jq
    // curl -H "Accept: application/xml" http://localhost:8080/customers |xml_pp
    // curl -H "Accept: application/rss+xml" http://localhost:8080/customers
    //
    // Write:
    // curl -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/customers |jq
    // curl -X POST -H 'Content-Type: application/xml' -d '<customer><code>JD</code><firstName>John</firstName><lastName>Doe</lastName></customer>' http://localhost:8080/customers |xml_pp
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
