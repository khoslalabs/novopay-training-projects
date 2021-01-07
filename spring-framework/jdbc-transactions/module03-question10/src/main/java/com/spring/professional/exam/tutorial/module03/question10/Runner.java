package com.spring.professional.exam.tutorial.module03.question10;

import com.spring.professional.exam.tutorial.module03.question10.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        try {
            employeeService.saveEmployeesWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();

        try {
            employeeService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();
    }
}
