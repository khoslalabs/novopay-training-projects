package com.spring.professional.exam.tutorial.module07.question19.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "home";
    }
}
