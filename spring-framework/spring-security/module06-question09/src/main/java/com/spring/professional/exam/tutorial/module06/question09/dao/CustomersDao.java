package com.spring.professional.exam.tutorial.module06.question09.dao;

import com.spring.professional.exam.tutorial.module06.question09.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
