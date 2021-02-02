package com.spring.professional.exam.tutorial.module05.question02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SquareNumberController {
    @GetMapping("square-number")
    public String squareNumber(@RequestParam("number") int number, Model model) {
        model.addAttribute("number", number);
        model.addAttribute("numberSquare", (int) Math.pow(number, 2));

        return "square-number";
    }
}
