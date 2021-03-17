package com.spring.professional.exam.tutorial.module07.question14.controller;

import com.spring.professional.exam.tutorial.module07.question14.ds.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

@RestController
@ResponseStatus(PARTIAL_CONTENT)
public class CustomersControllerV2 {

    // curl -i http://localhost:8080/api/v2/customerA
    @GetMapping("/api/v2/customerA")
    public Customer getCustomerA() {
        return new Customer("CC", "Caitlin", "Chen");
    }

    // curl -i http://localhost:8080/api/v2/customerB
    @GetMapping("/api/v2/customerB")
    public Customer getCustomerB() {
        return new Customer("KT", "Kamila", "Terry");
    }

    // curl -i http://localhost:8080/api/v2/customerC
    @GetMapping("/api/v2/customerC")
    public Customer getCustomerC() {
        return new Customer("EH", "Eve", "Harrell");
    }
}
