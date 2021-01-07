package com.spring.professional.exam.tutorial.module03.question01.unchecked;

import com.spring.professional.exam.tutorial.module03.question01.unchecked.dao.PersonDao;
import com.spring.professional.exam.tutorial.module03.question01.unchecked.ds.Person;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();

        personDao.save(person);
    }
}
