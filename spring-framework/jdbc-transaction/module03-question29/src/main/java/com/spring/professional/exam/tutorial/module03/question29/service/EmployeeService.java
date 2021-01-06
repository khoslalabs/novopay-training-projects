package com.spring.professional.exam.tutorial.module03.question29.service;

import com.spring.professional.exam.tutorial.module03.question29.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void queryEmployee() {
        System.out.println("Searching for John Doe employee...");
        System.out.println(
                employeeDao.findByFirstNameAndLastName("John", "Doe")
        );
    }
}
