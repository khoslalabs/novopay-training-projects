package com.spring.professional.exam.tutorial.module07.question16.controller;

import com.spring.professional.exam.tutorial.module07.question16.ds.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controllerA")
public class ControllerA {

    // MVC Controller example with @ResponseBody and regular Model/View method

    // curl -i http://localhost:8080/controllerA/methodA
    @GetMapping("/methodA")
    @ResponseBody
    public Customer methodA() {
        return new Customer("CC", "Caitlin", "Chen");
    }

    // curl -i http://localhost:8080/controllerA/methodB
    @GetMapping("/methodB")
    public String methodB(Model model) {
        model.addAttribute("customer", new Customer("CC", "Caitlin", "Chen"));

        return "customer";
    }
}
