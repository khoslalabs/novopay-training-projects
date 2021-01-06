package com.spring.professional.exam.tutorial.module03.question15.aspectj;

import com.spring.professional.exam.tutorial.module03.question15.aspectj.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        employeeService.transaction1And2();

        employeeService.transaction1And2WithPrecedingTransaction();
    }
}
