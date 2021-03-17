package com.spring.professional.exam.tutorial.module07.question03.dao;

import com.spring.professional.exam.tutorial.module07.question03.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
