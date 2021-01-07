package com.spring.professional.exam.tutorial.module03.question17;

import com.spring.professional.exam.tutorial.module03.question17.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.SQLException;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        employeeService.declarativeTransaction();
        employeeService.manualTransaction();
    }
}
