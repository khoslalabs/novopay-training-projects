package com.spring.professional.exam.tutorial.module01.question01.no.dependency.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesSalariesReportServiceTest {

    @InjectMocks
    private EmployeesSalariesReportService employeesSalariesReportService;

    @Test
    public void shouldGenerateSalaryReport() {

        // there is no way to write true unit test for this class,
        // since there is now way to inject mocks,
        // the only possibility without dependency injection
        // is to write integration test

    }
}