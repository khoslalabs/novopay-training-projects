package com.spring.professional.exam.tutorial.module03.question02.boot.service;

import com.spring.professional.exam.tutorial.module03.question02.boot.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        employeeDao.findEmployeeEmails()
                .forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }
}
