package com.spring.professional.exam.tutorial.module07.question06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // HTTP GET Examples:
    // curl -X GET http://localhost:8080/customers |jq
    // curl -X GET http://localhost:8080/customers/1 |jq
    // curl -X GET http://localhost:8080/customers/1/addresses |jq
    // curl -X GET http://localhost:8080/customers/1/addresses/1 |jq
    //
    // HTTP POST Examples:
    // curl -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/customers |jq
    // curl -X POST -H 'Content-Type: application/json' -d '{ "addressName": "Apartment Address", "streetNumber": 3551, "streetName": "Maple Lane", "aptNumber": 4, "city": "Huntsville", "state": "AL", "zipCode": "35816" }' http://localhost:8080/customers/4/addresses |jq
    //
    // HTTP PUT Examples:
    // curl -X PUT -H 'Content-Type: application/json' -d '[ { "code": "MB", "firstName": "Melody", "lastName": "Beard" }, { "code": "RF", "firstName": "Ralph", "lastName": "Farmer" }, { "code": "ES", "firstName": "Edward", "lastName": "Shea" } ]' http://localhost:8080/customers |jq
    // curl -X PUT -H 'Content-Type: application/json' -d '{ "code": "MB", "firstName": "Melody", "lastName": "Beard" }' http://localhost:8080/customers/1 |jq
    // curl -X PUT -H 'Content-Type: application/json' -d '[ { "addressName": "Address #1", "streetNumber": 3551, "streetName": "Rogers Street", "aptNumber": 7, "city": "Cincinnati", "state": "OH", "zipCode": "45223" }, { "addressName": "Address #2", "streetNumber": 3358, "streetName": "Public Works Drive", "aptNumber": 8, "city": "Knoxville", "state": "TN", "zipCode": "37921" }, { "addressName": "Address #3", "streetNumber": 1751, "streetName": "Edsel Road", "aptNumber": 9, "city": "North Hollywood", "state": "CA", "zipCode": "91605" } ]' http://localhost:8080/customers/1/addresses |jq
    // curl -X PUT -H 'Content-Type: application/json' -d '{ "addressName": "Address #1", "streetNumber": 3551, "streetName": "Rogers Street", "aptNumber": 7, "city": "Cincinnati", "state": "OH", "zipCode": "45223" }' http://localhost:8080/customers/1/addresses/1 |jq
    //
    // HTTP DELETE Examples:
    // curl -i -X DELETE http://localhost:8080/customers
    // curl -i -X DELETE http://localhost:8080/customers/1
    // curl -i -X DELETE http://localhost:8080/customers/1/addresses
    // curl -i -X DELETE http://localhost:8080/customers/1/addresses/1
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
