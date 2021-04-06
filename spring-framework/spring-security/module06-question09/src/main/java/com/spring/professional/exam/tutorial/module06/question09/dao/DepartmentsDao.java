package com.spring.professional.exam.tutorial.module06.question09.dao;

import com.spring.professional.exam.tutorial.module06.question09.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
