package com.spring.professional.exam.tutorial.module01.question19.dao;

import com.spring.professional.exam.tutorial.module01.question19.ds.Person;

public interface PersonDao {
    Person findById(int id);

    void save(Person person);
}
