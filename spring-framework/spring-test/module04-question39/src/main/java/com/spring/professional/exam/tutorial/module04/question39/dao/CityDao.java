package com.spring.professional.exam.tutorial.module04.question39.dao;

import com.spring.professional.exam.tutorial.module04.question39.ds.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends CrudRepository<City, Integer> {
}
