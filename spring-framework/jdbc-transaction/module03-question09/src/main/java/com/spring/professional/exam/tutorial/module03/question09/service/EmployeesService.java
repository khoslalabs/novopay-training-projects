package com.spring.professional.exam.tutorial.module03.question09.service;

import com.spring.professional.exam.tutorial.module03.question09.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question09.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeesService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveEmployeeWithoutTransaction() {
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }

    @Transactional
    public void saveEmployeeInTransaction() {
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }
}
