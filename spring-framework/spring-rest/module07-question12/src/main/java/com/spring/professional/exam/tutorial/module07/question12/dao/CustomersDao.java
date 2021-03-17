package com.spring.professional.exam.tutorial.module07.question12.dao;

import com.spring.professional.exam.tutorial.module07.question12.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
