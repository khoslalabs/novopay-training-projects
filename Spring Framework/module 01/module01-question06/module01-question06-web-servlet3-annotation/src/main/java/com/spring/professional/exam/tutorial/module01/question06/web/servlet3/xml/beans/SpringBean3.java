package com.spring.professional.exam.tutorial.module01.question06.web.servlet3.xml.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean3 {
    public SpringBean3() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
