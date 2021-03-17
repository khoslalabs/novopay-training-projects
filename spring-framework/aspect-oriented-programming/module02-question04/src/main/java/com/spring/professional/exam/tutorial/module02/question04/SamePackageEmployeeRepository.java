package com.spring.professional.exam.tutorial.module02.question04;

import com.spring.professional.exam.tutorial.module02.question04.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class SamePackageEmployeeRepository {
    public void saveEmployee(Employee employee) {
    }

    protected void deleteEmployee(long id) {
    }

    void deleteEmployeeByEmail(String email) {
    }

    private void deleteEmployeeByPhone(String phone) {
        System.out.println("deleteEmployeeByPhone method called");
    }
}
