package com.spring.professional.exam.tutorial.module03.question28.dao.regular;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
