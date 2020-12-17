package com.spring.professional.exam.tutorial.module02.question07;

import com.spring.professional.exam.tutorial.module02.question07.beans.*;
import com.spring.professional.exam.tutorial.module02.question07.ds.Department;
import com.spring.professional.exam.tutorial.module02.question07.ds.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        HelloChildBean springBean = context.getBean(HelloChildBean.class);
        springBean.sayHello("John", 5);
        springBean.validateName("Jane");
        springBean.saveCounterValue(7);
        springBean.savePerson(new Person());

        ITaxBean taxBean1 = context.getBean(ITaxBean.class);
        TaxBean2 taxBean2 = context.getBean(TaxBean2.class);
        taxBean1.calculateTax(5f);
        taxBean2.calculateTax(10f);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        Department department = departmentRepository.findDepartment("DEPA%");
        departmentRepository.updateDepartment(5, department);

        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
        employeeBean.setId(5);
        employeeBean.setCubicId("A-105");
        employeeBean.setName("John");
        employeeBean.setWorkPhone("18885555");
        employeeBean.getId();
        employeeBean.getCubicId();
        employeeBean.getName();
        employeeBean.getWorkPhone();
    }
}
