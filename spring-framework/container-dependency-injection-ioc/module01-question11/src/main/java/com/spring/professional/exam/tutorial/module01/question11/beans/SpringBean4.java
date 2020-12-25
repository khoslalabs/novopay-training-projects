package com.spring.professional.exam.tutorial.module01.question11.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SpringBean4 {
    public SpringBean4() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Lazy Singleton Bean");
    }
}
