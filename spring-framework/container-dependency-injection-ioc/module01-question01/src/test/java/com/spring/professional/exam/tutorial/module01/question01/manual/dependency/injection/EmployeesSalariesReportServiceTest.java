package com.spring.professional.exam.tutorial.module01.question01.manual.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question01.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.SalaryReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesSalariesReportServiceTest {
    @InjectMocks
    private EmployeesSalariesReportService employeesSalariesReportService;
    @Mock
    private EmployeeDao employeeDao;
    @Mock
    private EmployeeSalaryCalculator employeeSalaryCalculator;
    @Mock
    private SalaryReport salaryReport;
    @Mock
    private List<Employee> employees;
    @Mock
    private List<EmployeeSalary> employeeSalaries;

    @Test
    public void shouldGenerateSalaryReport() {
        when(employeeDao.findAll()).thenReturn(employees);
        when(employeeSalaryCalculator.calculateSalaries(employees)).thenReturn(employeeSalaries);

        employeesSalariesReportService.generateReport();

        verify(salaryReport).writeReport(employeeSalaries);
    }
}