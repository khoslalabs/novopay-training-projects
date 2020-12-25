package com.spring.professional.exam.tutorial.module01.question06.non.web;

import com.spring.professional.exam.tutorial.module01.question06.non.web.beans.SpringBean1;
import com.spring.professional.exam.tutorial.module01.question06.non.web.defined.configuration.ConfigurationStatic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextExample1b {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigurationStatic.class
        );

        SpringBean1 bean = context.getBean(SpringBean1.class);

        bean.sayHello();
    }
}
