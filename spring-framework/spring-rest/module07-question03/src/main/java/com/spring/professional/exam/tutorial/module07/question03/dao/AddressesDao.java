package com.spring.professional.exam.tutorial.module07.question03.dao;

import com.spring.professional.exam.tutorial.module07.question03.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressesDao extends CrudRepository<Address, Integer> {
}
