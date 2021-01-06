package com.spring.professional.exam.tutorial.module03.question22.dao;

import com.spring.professional.exam.tutorial.module03.question22.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface JpaEmployeeDao extends CrudRepository<Employee, Integer> {
}
