package com.spring.professional.exam.tutorial.module04.question18.dao;

import com.spring.professional.exam.tutorial.module04.question18.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
