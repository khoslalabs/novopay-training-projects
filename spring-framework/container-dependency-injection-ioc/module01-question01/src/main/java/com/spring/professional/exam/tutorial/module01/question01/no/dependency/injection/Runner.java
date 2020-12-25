package com.spring.professional.exam.tutorial.module01.question01.no.dependency.injection;

public class Runner {
    public static void main(String... args) {
        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService();

        employeesSalariesReportService.generateReport();
    }
}
