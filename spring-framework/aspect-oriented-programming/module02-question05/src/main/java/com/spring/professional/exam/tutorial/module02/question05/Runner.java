package com.spring.professional.exam.tutorial.module02.question05;

import com.spring.professional.exam.tutorial.module02.question05.repository.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        repository.findEmployeeById(5);

        try {
            repository.findEmployeeById(-1);
        } catch (Exception ignored) {
            // ignored on purpose
        }
    }
}
