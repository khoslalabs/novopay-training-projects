package com.spring.professional.exam.tutorial.module03.question25.dao;

import com.spring.professional.exam.tutorial.module03.question25.ds.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    Employee findByEmail(String email);

    List<Employee> findByLastName(String lastName);

    List<Employee> findBySalaryBetween(float min, float max);
}
