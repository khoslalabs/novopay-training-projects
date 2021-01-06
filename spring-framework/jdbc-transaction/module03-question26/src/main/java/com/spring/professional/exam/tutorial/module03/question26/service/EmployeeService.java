package com.spring.professional.exam.tutorial.module03.question26.service;

import com.spring.professional.exam.tutorial.module03.question26.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question26.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question26.ds.EmployeeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void saveEmployee() {
        System.out.println("Saving employee...");

        employeeDao.save(new Employee(new EmployeeKey("John", "Doe"), "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));

        System.out.println("Employee saved");
    }

    public void listEmployee() {
        System.out.println("Searching for John Doe employee...");
        employeeDao.findById(new EmployeeKey("John", "Doe")).ifPresent(System.out::println);
    }
}
