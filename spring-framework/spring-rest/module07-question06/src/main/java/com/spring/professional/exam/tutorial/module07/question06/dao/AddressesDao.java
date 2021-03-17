package com.spring.professional.exam.tutorial.module07.question06.dao;

import com.spring.professional.exam.tutorial.module07.question06.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressesDao extends CrudRepository<Address, Integer> {
}
