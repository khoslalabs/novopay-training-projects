package com.spring.professional.exam.tutorial.module02.question03.service.a;

import com.spring.professional.exam.tutorial.module02.question03.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {
    }

    @Override
    public void deleteEmployee(Employee employee) {
    }
}
