package com.spring.professional.exam.tutorial.module01.question10.annotations.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class RunnerAdvancedConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigurationAdvanced.class);

        context.registerShutdownHook();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
