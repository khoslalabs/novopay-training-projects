package com.spring.professional.exam.tutorial.module01.question10.annotations.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {
    public SpringBean2() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
