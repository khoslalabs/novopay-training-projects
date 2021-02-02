package com.spring.professional.exam.tutorial.module07.question02.dao;

import com.spring.professional.exam.tutorial.module07.question02.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressesDao extends CrudRepository<Address, Integer> {
}
