package com.spring.professional.exam.tutorial.module03.question14;

import com.spring.professional.exam.tutorial.module03.question14.service.EmployeeService;
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

        employeeService.callRequiredWithoutCurrentTransaction();
        employeeService.callRequiredWithCurrentTransaction();

        employeeService.callSupportsWithoutCurrentTransaction();
        employeeService.callSupportsWithCurrentTransaction();

        employeeService.callMandatoryWithoutCurrentTransaction();
        employeeService.callMandatoryWithCurrentTransaction();

        employeeService.callRequiresNewWithoutCurrentTransaction();
        employeeService.callRequiresNewWithCurrentTransaction();

        employeeService.callNotSupportedWithoutCurrentTransaction();
        employeeService.callNotSupportedWithCurrentTransaction();

        employeeService.callNeverWithoutCurrentTransaction();
        employeeService.callNeverWithCurrentTransaction();

        employeeService.callNestedWithoutCurrentTransaction();
        employeeService.callNestedWithCurrentTransaction();
    }
}
