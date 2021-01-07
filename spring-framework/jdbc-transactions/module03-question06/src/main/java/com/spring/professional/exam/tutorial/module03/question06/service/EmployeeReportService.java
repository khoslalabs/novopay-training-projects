package com.spring.professional.exam.tutorial.module03.question06.service;

import com.spring.professional.exam.tutorial.module03.question06.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());

        System.out.println("Employee Report Stop");
    }

    @Transactional
    public void printReportInTransaction() {
        System.out.println("Employee Report Start - Transactional");

        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());

        System.out.println("Employee Report Stop - Transactional");
    }
}
