package com.spring.professional.exam.tutorial.module01.question09.non.web.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class SpringBean1 {

    public void sayHello() {
        System.out.println("Hello");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy " + getClass().getSimpleName());
    }
}
