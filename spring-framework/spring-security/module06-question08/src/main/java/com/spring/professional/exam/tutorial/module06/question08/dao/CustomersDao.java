package com.spring.professional.exam.tutorial.module06.question08.dao;

import com.spring.professional.exam.tutorial.module06.question08.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
