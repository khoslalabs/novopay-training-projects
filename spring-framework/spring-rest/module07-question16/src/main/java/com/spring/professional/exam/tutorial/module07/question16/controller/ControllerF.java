package com.spring.professional.exam.tutorial.module07.question16.controller;

import com.spring.professional.exam.tutorial.module07.question16.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question16.exception.CustomBadRequestException;
import com.spring.professional.exam.tutorial.module07.question16.exception.CustomDataRejectedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controllerF")
public class ControllerF {

    // Example usage of @ExceptionHandler annotation

    // curl -i http://localhost:8080/controllerF/methodA
    @GetMapping("/methodA")
    public Customer methodA() {
        throw new CustomBadRequestException();
    }

    // curl -i http://localhost:8080/controllerF/methodB
    // exception is handled by global exception handler in CustomControllerAdvice
    @GetMapping("/methodB")
    public Customer methodB() {
        throw new CustomDataRejectedException();
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public String customBadRequestExceptionHandler() {
        return "Exception was handled by custom handler";
    }
}
