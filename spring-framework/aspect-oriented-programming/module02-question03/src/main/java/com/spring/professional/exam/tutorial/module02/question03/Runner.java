package com.spring.professional.exam.tutorial.module02.question03;

import com.spring.professional.exam.tutorial.module02.question03.ds.Employee;
import com.spring.professional.exam.tutorial.module02.question03.service.a.EmployeeRepository;
import com.spring.professional.exam.tutorial.module02.question03.service.b.AlternateEmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        AlternateEmployeeRepository alternateEmployeeRepository = context.getBean(AlternateEmployeeRepository.class);

        Employee employee = employeeRepository.findEmployeeById(5);
        employeeRepository.saveEmployee(employee);
        employeeRepository.deleteEmployee(employee);

        alternateEmployeeRepository.findEmployeeById(5);
        alternateEmployeeRepository.saveEmployee(employee);
        alternateEmployeeRepository.deleteEmployee(employee);
    }
}
