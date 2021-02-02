package com.spring.professional.exam.tutorial.module07.question16.controller;

import com.spring.professional.exam.tutorial.module07.question16.ds.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controllerB")
public class ControllerB {

    // @RestController annotation example

    // curl -i http://localhost:8080/controllerB/methodA
    @GetMapping("/methodA")
    public Customer methodA() {
        return new Customer("CC", "Caitlin", "Chen");
    }
}
