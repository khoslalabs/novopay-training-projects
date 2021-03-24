package com.spring.professional.exam.tutorial.module06.question11.dao;

import com.spring.professional.exam.tutorial.module06.question11.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
