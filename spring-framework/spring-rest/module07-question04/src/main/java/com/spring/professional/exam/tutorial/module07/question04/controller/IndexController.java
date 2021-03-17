package com.spring.professional.exam.tutorial.module07.question04.controller;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class IndexController {

    @GetMapping({"/", "/index"})
    public ResourceSupport index() {
        ResourceSupport resourceSupport = new ResourceSupport();
        resourceSupport.add(linkTo(methodOn(IndexController.class).index()).withSelfRel());
        resourceSupport.add(linkTo(methodOn(CustomersController.class).listCustomers()).withRel("customers"));
        return resourceSupport;
    }
}
