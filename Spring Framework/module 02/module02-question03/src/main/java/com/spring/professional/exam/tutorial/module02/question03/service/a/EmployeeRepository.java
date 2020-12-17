package com.spring.professional.exam.tutorial.module02.question03.service.a;

import com.spring.professional.exam.tutorial.module02.question03.ds.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
