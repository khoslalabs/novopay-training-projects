package com.spring.professional.exam.tutorial.module07.question17.controller;

import com.spring.professional.exam.tutorial.module07.question17.ds.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
public class ApiController {

    // curl http://localhost:8080/api/methodA
    @GetMapping(value = "/methodA", produces = APPLICATION_JSON_VALUE)
    public Customer methodA() {
        return new Customer("CC", "Caitlin", "Chen");
    }
}
