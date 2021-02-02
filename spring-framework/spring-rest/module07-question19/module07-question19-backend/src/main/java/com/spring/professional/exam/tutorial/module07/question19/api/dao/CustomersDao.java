package com.spring.professional.exam.tutorial.module07.question19.api.dao;

import com.spring.professional.exam.tutorial.module07.question19.api.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
