package com.spring.professional.exam.tutorial.module01.question10.annotations;

import com.spring.professional.exam.tutorial.module01.question10.annotations.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.sayHello();
    }
}
