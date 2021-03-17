package com.spring.professional.exam.tutorial.module07.question01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // curl -X GET -vs http://localhost:8080/customers |jq
    // curl -X GET -vs http://localhost:8080/customers/1 |jq
    // curl -X GET -vs http://localhost:8080/customers/700 |jq
    // curl -X POST -v -H 'Content-Type: application/json' -d '{ "code": "JD", "firstName": "John", "lastName": "Doe", "address": "7147 North Bridge Road, PA 14368" }' http://localhost:8080/customers |jq
    // curl -X PUT -v -H 'Content-Type: application/json' -d '{ "code": "JF", "firstName": "John", "lastName": "Freeman", "address": "7147 North Bridge Road, PA 14368" }' http://localhost:8080/customers/6 |jq
    // curl -X DELETE -vs http://localhost:8080/customers/3
    // curl -X DELETE -vs http://localhost:8080/customers/4
    // curl -X DELETE -vs http://localhost:8080/customers/800
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
