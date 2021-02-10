package com.spring.professional.exam.tutorial.module04.question15.jetty.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String index() {
        return "Hello from jetty embedded container.";
    }
}
