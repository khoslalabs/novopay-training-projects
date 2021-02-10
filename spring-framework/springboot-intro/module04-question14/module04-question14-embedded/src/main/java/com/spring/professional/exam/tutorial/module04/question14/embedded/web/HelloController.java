package com.spring.professional.exam.tutorial.module04.question14.embedded.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String index() {
        return "Hello from embedded container.";
    }
}
