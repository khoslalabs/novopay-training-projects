package com.spring.professional.exam.tutorial.module03.question25.service;

import com.spring.professional.exam.tutorial.module03.question25.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question25.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void saveAllEmployees() {
        System.out.println("Saving all employees...");

        employeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDao.save(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDao.save(new Employee(3, "Jayvon", "Krueger", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDao.save(new Employee(4, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDao.save(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));

        System.out.println("Saved all employees");
    }

    public void listSelectedEmployees() {
        System.out.println("Listing all employees...");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println("Listing employee with id 3");
        employeeDao.findById(3).ifPresent(System.out::println);

        System.out.println("Employee by email Willow.Zhang@corp.com");
        System.out.println(
                employeeDao.findByEmail("Willow.Zhang@corp.com")
        );

        System.out.println("Employee by salary between 90k and 110k");
        employeeDao.findBySalaryBetween(90000, 110000).forEach(System.out::println);

        System.out.println("Employee by lastname Krueger");
        System.out.println(
                employeeDao.findByLastName("Krueger")
        );
    }
}
