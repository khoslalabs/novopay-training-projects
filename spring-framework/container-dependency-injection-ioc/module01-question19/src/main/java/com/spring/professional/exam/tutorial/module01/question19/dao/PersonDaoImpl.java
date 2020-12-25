package com.spring.professional.exam.tutorial.module01.question19.dao;

import com.spring.professional.exam.tutorial.module01.question19.ds.Person;

public class PersonDaoImpl implements PersonDao {
    @Override
    public Person findById(int id) {
        System.out.println("Searching for person...");
        return new Person();
    }

    @Override
    public void save(Person person) {
        System.out.println("Saving person...");
    }
}
