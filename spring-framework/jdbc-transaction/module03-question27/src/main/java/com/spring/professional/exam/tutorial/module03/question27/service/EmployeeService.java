package com.spring.professional.exam.tutorial.module03.question27.service;

import com.spring.professional.exam.tutorial.module03.question27.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void queryEmployee() {
        System.out.println("Top 3 Employees By Salary");
        employeeDao.findTop3ByOrderBySalaryDesc().forEach(System.out::println);

        System.out.println("Searching for John Doe employee...");
        System.out.println(
                employeeDao.findByFirstNameAndLastName("John", "Doe")
        );

        System.out.println("Employees hired between 12 July 2019 and 19 July 2019");
        employeeDao.findByHireDateBetween(Date.valueOf("2019-07-12"), Date.valueOf("2019-07-19")).forEach(System.out::println);

        System.out.println("Employees order by hire date");
        employeeDao.findByOrderByHireDateDesc().forEach(System.out::println);
    }
}
