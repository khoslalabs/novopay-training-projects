package com.spring.professional.exam.tutorial.module02.question04.service.b;

import com.spring.professional.exam.tutorial.module02.question04.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public /*final*/ class AlternateEmployeeRepository {
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    public void saveEmployee(Employee employee) {
    }

    public /*final*/ void deleteEmployee(Employee employee) {
    }

    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }
}
