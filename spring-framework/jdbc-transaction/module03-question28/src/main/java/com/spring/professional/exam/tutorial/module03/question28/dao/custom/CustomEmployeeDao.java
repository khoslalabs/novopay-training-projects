package com.spring.professional.exam.tutorial.module03.question28.dao.custom;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomEmployeeDao extends CrudRepository<Employee, Integer>, CustomEmployeeFindRepository {
}
