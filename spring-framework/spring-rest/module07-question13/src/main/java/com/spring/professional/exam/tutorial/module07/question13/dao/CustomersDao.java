package com.spring.professional.exam.tutorial.module07.question13.dao;

import com.spring.professional.exam.tutorial.module07.question13.ds.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
    List<Customer> findByFirstNameLike(String firstNamePattern);
}
