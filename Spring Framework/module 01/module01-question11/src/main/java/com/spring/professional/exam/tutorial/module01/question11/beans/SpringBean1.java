package com.spring.professional.exam.tutorial.module01.question11.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {
    public SpringBean1() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }
}
