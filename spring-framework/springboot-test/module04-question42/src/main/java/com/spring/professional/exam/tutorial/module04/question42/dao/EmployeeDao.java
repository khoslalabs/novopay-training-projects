package com.spring.professional.exam.tutorial.module04.question42.dao;

import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
