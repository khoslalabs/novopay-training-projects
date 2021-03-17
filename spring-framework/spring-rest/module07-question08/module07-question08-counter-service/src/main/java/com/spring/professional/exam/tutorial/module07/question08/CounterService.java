package com.spring.professional.exam.tutorial.module07.question08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CounterService {

    // curl -X POST -H 'Content-Type: application/json' -d '{ "number": "5" }' http://localhost:8080/counter/stateless/countUp| jq
    // curl -b cookies.txt -c cookies.txt -X POST http://localhost:8080/counter/stateful/countUp |jq
    public static void main(String[] args) {
        SpringApplication.run(CounterService.class, args);
    }
}
