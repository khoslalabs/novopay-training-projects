package com.spring.professional.exam.tutorial.module01.question01.no.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question01.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.PdfSalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    void generateReport() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();

        EmployeeSalaryCalculator employeeSalaryCalculator = new EmployeeSalaryCalculator();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        PdfSalaryReport pdfSalaryReport = new PdfSalaryReport();
        pdfSalaryReport.writeReport(employeeSalaries);
    }
}
