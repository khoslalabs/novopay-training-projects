package com.spring.professional.exam.tutorial.module03.question26.dao;

import com.spring.professional.exam.tutorial.module03.question26.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question26.ds.EmployeeKey;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, EmployeeKey> {
}
