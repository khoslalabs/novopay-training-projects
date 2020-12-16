package com.spring.professional.exam.tutorial.module01.question22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        System.out.println("Printing Bean Names:");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        System.out.println("Fetching Bean by Alias:");
        System.out.println(
                context.getBean("thirdSpringBean").getClass().getSimpleName()
        );
    }
}
