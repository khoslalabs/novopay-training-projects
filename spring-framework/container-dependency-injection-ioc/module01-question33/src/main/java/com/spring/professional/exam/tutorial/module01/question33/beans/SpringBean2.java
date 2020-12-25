package com.spring.professional.exam.tutorial.module01.question33.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {

    public static final String STATIC_VALUE = "staticFieldValue";
    public String property = "propertyValue";

    public static String staticMethod() {
        return "staticMethodValue";
    }

    public String method() {
        return "methodValue";
    }
}
