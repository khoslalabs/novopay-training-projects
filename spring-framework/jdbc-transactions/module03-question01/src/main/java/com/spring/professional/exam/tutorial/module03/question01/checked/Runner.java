package com.spring.professional.exam.tutorial.module03.question01.checked;

import com.spring.professional.exam.tutorial.module03.question01.checked.dao.PersonDao;
import com.spring.professional.exam.tutorial.module03.question01.checked.ds.Person;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.DaoFilesystemException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonInvalidException;
import com.spring.professional.exam.tutorial.module03.question01.checked.exception.PersonStoreException;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();

        try {
            personDao.save(person);
        } catch (PersonInvalidException e) {
            // handle exception
        } catch (PersonStoreException e) {
            // handle exception
        } catch (DaoFilesystemException e) {
            // handle exception
        }
    }
}
