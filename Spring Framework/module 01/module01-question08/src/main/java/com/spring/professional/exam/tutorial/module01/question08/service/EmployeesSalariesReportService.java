package com.spring.professional.exam.tutorial.module01.question08.service;

import com.spring.professional.exam.tutorial.module01.question08.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question08.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question08.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question08.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.question08.report.SalaryReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesSalariesReportService {
    private final EmployeeDao employeeDao;
    private final EmployeeSalaryCalculator employeeSalaryCalculator;
    private final SalaryReport salaryReport;

    EmployeesSalariesReportService(EmployeeDao employeeDao, EmployeeSalaryCalculator employeeSalaryCalculator, SalaryReport salaryReport) {
        this.employeeDao = employeeDao;
        this.employeeSalaryCalculator = employeeSalaryCalculator;
        this.salaryReport = salaryReport;
    }

    public void generateReport() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        salaryReport.writeReport(employeeSalaries);
    }
}
