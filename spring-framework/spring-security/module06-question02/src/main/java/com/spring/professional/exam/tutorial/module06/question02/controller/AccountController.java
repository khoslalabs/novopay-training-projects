package com.spring.professional.exam.tutorial.module06.question02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account")
    public String account() {
        return "account";
    }
}
