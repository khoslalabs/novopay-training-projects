package com.spring.professional.exam.tutorial.module04.question42.dao;

import com.spring.professional.exam.tutorial.module04.question42.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityDao extends CrudRepository<City, Integer> {
    Optional<City> findByName(String name);
}
