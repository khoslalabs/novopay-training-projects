package com.spring.professional.exam.tutorial.module07.question13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // HTTP GET - 200 (OK)
    // curl -i -X GET http://localhost:8080/customers
    // curl -i -X GET http://localhost:8080/customers/1
    //
    // HTTP POST - 201 (Created)
    // curl -i -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/customers
    // HTTP POST - 200 (OK)
    // curl -i -X POST http://localhost:8080/customers/search -H 'Content-Type: application/json' -d '{"firstNameLike": "%a%l%"}'
    // HTTP POST - 204 (No Content) - for this example, also consider using HTTP HEAD instead of HTTP POST
    // curl -i -X POST http://localhost:8080/customers/count
    //
    // HTTP PUT - 201 (Created)
    // curl -i -X PUT -H 'Content-Type: application/json' -d '{ "code": "MB", "firstName": "Melody", "lastName": "Beard" }' http://localhost:8080/customers/5
    // HTTP PUT - 200 (OK)
    // curl -i -X PUT -H 'Content-Type: application/json' -d '{ "code": "RF", "firstName": "Ralph", "lastName": "Farmer" }' http://localhost:8080/customers/1
    // HTTP PUT - 204 (No Content)
    // curl -i -X PUT -H 'Content-Type: application/json' -d '[ { "code": "MB", "firstName": "Melody", "lastName": "Beard" }, { "code": "RF", "firstName": "Ralph", "lastName": "Farmer" }, { "code": "ES", "firstName": "Edward", "lastName": "Shea" } ]' http://localhost:8080/customers
    //
    // HTTP DELETE - 204 (No Content)
    // curl -i -X DELETE http://localhost:8080/customers/6
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
