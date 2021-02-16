package com.spring.professional.exam.tutorial.module04.question29;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class HelloController {
    private Random random = new Random();

    @GetMapping
    public String index() {
        if (random.nextInt() % 4 < 1)
            throw new IllegalStateException("Fail the request");

        return "OK";
    }
}
