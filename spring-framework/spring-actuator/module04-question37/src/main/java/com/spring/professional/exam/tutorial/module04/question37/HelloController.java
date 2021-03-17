package com.spring.professional.exam.tutorial.module04.question37;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello";
    }
}
