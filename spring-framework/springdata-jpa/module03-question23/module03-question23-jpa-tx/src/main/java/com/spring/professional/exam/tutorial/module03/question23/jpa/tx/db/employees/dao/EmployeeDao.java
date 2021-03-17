package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.dao;

import com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
