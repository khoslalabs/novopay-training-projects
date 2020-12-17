package com.spring.professional.exam.tutorial.module02.question07.beans;

import com.spring.professional.exam.tutorial.module02.question07.annotation.MonitoredRepository;
import com.spring.professional.exam.tutorial.module02.question07.ds.Department;
import org.springframework.stereotype.Component;

@Component
@MonitoredRepository
public class DepartmentRepository {

    public Department findDepartment(String pattern) {
        return new Department();
    }

    public void updateDepartment(int id, Department department) {
    }
}
