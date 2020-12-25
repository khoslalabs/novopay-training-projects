package com.spring.professional.exam.tutorial.module01.question19.proxy.jdk;

import com.spring.professional.exam.tutorial.module01.question19.dao.PersonDao;
import com.spring.professional.exam.tutorial.module01.question19.dao.PersonDaoImpl;
import com.spring.professional.exam.tutorial.module01.question19.ds.Person;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = (PersonDao) Proxy.newProxyInstance(
                PersonDao.class.getClassLoader(), PersonDaoImpl.class.getInterfaces(),
                new PersonDaoInvocationHandler(
                        new PersonDaoImpl()
                )
        );

        Person person = personDao.findById(5);
        personDao.save(person);
    }
}
