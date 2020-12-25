package com.spring.professional.exam.tutorial.module01.question19.proxy.manual;

import com.spring.professional.exam.tutorial.module01.question19.dao.PersonDao;
import com.spring.professional.exam.tutorial.module01.question19.dao.PersonDaoImpl;
import com.spring.professional.exam.tutorial.module01.question19.ds.Person;

public class Runner {
    public static void main(String[] args) {
        //PersonDao personDao = new PersonDaoImpl();
        PersonDao personDao = new PersonDaoProxy(
                new PersonDaoImpl()
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
