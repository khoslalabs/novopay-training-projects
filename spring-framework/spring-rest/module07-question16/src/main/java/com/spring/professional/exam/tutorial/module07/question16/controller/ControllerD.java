package com.spring.professional.exam.tutorial.module07.question16.controller;

import com.spring.professional.exam.tutorial.module07.question16.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question16.exception.CustomBadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

@RestController
@RequestMapping("controllerD")
public class ControllerD {

    // Example usage of @ResponseStatus on top of method in controller and on top of custom exception

    // curl -i http://localhost:8080/controllerD/customerA
    @GetMapping("/customerA")
    @ResponseStatus(ACCEPTED)
    public Customer getCustomerA() {
        return new Customer("CC", "Caitlin", "Chen");
    }

    // curl -i http://localhost:8080/controllerD/customerB
    @GetMapping("/customerB")
    @ResponseStatus(PARTIAL_CONTENT)
    public Customer getCustomerB() {
        return new Customer("KT", "Kamila", "Terry");
    }

    // curl -i http://localhost:8080/controllerD/customerC
    @GetMapping("/customerC")
    public Customer getCustomerC() {
        throw new CustomBadRequestException();
    }
}
