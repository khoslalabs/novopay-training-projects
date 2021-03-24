package com.spring.professional.exam.tutorial.module06.question08.dao;

import com.spring.professional.exam.tutorial.module06.question08.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
