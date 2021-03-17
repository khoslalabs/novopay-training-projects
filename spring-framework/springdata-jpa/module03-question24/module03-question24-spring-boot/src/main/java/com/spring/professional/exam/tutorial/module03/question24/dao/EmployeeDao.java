package com.spring.professional.exam.tutorial.module03.question24.dao;

import com.spring.professional.exam.tutorial.module03.question24.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
