package com.spring.professional.exam.tutorial.module03.question28.dao.custom;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;

public interface CustomEmployeeFindRepository {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
