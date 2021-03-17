package com.spring.professional.exam.tutorial.module07.question04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // curl -i -X GET http://localhost:8443/
    // curl -k -X GET https://localhost:8443/ |jq
    // curl -k -X GET https://localhost:8443/customers |jq
    // curl -k -X GET --user api-user:api-user https://localhost:8443/customers |jq
    // curl -k -X POST --user api-user:api-user -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' https://localhost:8443/customers |jq
    // curl -k -i -X DELETE --user api-user:api-user https://localhost:8443/customers/1

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
