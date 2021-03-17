package com.spring.professional.exam.tutorial.module04.question17.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        EmployeesService employeesService = context.getBean(EmployeesService.class);

        employeesService.printEmails();
    }
}
