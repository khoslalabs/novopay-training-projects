package com.spring.professional.exam.tutorial.module06.question05.dao;

import com.spring.professional.exam.tutorial.module06.question05.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
