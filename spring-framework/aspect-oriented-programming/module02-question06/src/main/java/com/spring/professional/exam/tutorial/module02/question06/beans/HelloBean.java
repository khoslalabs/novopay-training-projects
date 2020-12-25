package com.spring.professional.exam.tutorial.module02.question06.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public void sayHello() {
        System.out.println("Hello from Spring Bean");
    }
}
