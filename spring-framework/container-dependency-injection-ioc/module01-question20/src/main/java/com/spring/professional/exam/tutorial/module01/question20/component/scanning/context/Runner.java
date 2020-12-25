package com.spring.professional.exam.tutorial.module01.question20.component.scanning.context;

import com.spring.professional.exam.tutorial.module01.question20.component.scanning.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);

        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.printDependencies();
    }
}
