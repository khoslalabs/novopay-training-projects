package com.spring.professional.exam.tutorial.module02.question04;

import com.spring.professional.exam.tutorial.module02.question04.service.a.EmployeeRepository;
import com.spring.professional.exam.tutorial.module02.question04.service.b.AlternateEmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        AlternateEmployeeRepository alternateEmployeeRepository = context.getBean(AlternateEmployeeRepository.class);
        SamePackageEmployeeRepository samePackageEmployeeRepository = context.getBean(SamePackageEmployeeRepository.class);

        //employeeRepository.findAndUpdateEmployeeById(5, new Employee());
        //employeeRepository.findEmployeeById(5);
        //employeeRepository.saveEmployee(new Employee());
        //employeeRepository.deleteEmployee(new Employee());

        //Method deleteByEmail = employeeRepository.getClass().getDeclaredMethod("deleteByEmail", String.class);
        //deleteByEmail.setAccessible(true);
        //deleteByEmail.invoke(samePackageEmployeeRepository, "john@corp.net");

        //alternateEmployeeRepository.findAndUpdateEmployeeById(5, new Employee());
        //alternateEmployeeRepository.findEmployeeById(5);
        //alternateEmployeeRepository.saveEmployee(new Employee());
        //alternateEmployeeRepository.deleteEmployee(new Employee());

        //samePackageEmployeeRepository.saveEmployee(new Employee());
        //samePackageEmployeeRepository.deleteEmployee(5);
        //samePackageEmployeeRepository.deleteEmployeeByEmail("john@corp.net");

        //Method deleteEmployeeByPhone = samePackageEmployeeRepository.getClass().getSuperclass().getDeclaredMethod("deleteEmployeeByPhone", String.class);
        //deleteEmployeeByPhone.setAccessible(true);
        //deleteEmployeeByPhone.invoke(samePackageEmployeeRepository, "202-555-0140");
    }
}
