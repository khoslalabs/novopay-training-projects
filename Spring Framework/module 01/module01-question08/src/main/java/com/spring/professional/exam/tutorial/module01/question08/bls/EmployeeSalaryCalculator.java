package com.spring.professional.exam.tutorial.module01.question08.bls;

import com.spring.professional.exam.tutorial.module01.question08.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question08.ds.EmployeeSalary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeSalaryCalculator {
    public List<EmployeeSalary> calculateSalaries(List<Employee> employees) {
        System.out.println("Calculating salaries");
        return Collections.emptyList();
    }
}
