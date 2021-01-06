package com.spring.professional.exam.tutorial.module03.question22.service;

import com.spring.professional.exam.tutorial.module03.question22.dao.JdbcEmployeeDao;
import com.spring.professional.exam.tutorial.module03.question22.dao.JpaEmployeeDao;
import com.spring.professional.exam.tutorial.module03.question22.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private JpaEmployeeDao jpaEmployeeDao;
    @Autowired
    private JdbcEmployeeDao jdbcEmployeeDao;

    @Transactional
    public void saveEmployeesUnderOneTransaction() {
        System.out.println("Saving all employees...");

        System.out.println("Saving employee with JPA...");
        jpaEmployeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        System.out.println("Saved employee with JPA");

        System.out.println("Saving employee with JDBC...");
        jdbcEmployeeDao.save(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        System.out.println("Saved employee with JDBC");

        System.out.println("Saved all employees");
    }

    @Transactional
    public void listAllEmployees() {
        System.out.println("Listing all employees...");

        jpaEmployeeDao.findAll().forEach(System.out::println);
    }
}
