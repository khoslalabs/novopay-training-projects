package com.spring.professional.exam.tutorial.module02.question04.service.a;

import com.spring.professional.exam.tutorial.module02.question04.ds.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void findAndUpdateEmployeeById(long id, Employee employeeToMerge);
}
