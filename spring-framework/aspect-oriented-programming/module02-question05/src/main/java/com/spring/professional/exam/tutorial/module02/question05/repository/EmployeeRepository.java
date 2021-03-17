package com.spring.professional.exam.tutorial.module02.question05.repository;

import com.spring.professional.exam.tutorial.module02.question05.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    public Employee findEmployeeById(long id) {
        if (id == -1)
            throw new IllegalArgumentException("id cannot be -1");

        return new Employee(id);
    }

    public void saveEmployee(Employee employee) {
    }

    public void deleteEmployee(Employee employee) {
    }
}
