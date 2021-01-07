package com.spring.professional.exam.tutorial.module03.question12.service;

import com.spring.professional.exam.tutorial.module03.question12.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question12.ds.Employee;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.concurrent.CountDownLatch;

@Getter
abstract class AbstractIsolationExample {
    @Autowired
    private EmployeeDao employeeDao;

    CountDownLatch fistReadOnUnsavedAndNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch secondReadOnSavedButNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch writeDoneNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch writeDoneAndCommittedLatch = new CountDownLatch(1);
    CountDownLatch readWriteLatch = new CountDownLatch(2);

    void readOperation() {
        employeeDao.findAllEmployeesByIdRange(1, 6).forEach(System.out::println);
    }

    void writeOperation() {
        employeeDao.saveEmployee(new Employee(4, "Mary", "Duncan", "Mary.Duncam@cor.com", "555-55-60", Date.valueOf("2019-07-30"), 130000));
        employeeDao.maskEmail(6);
    }
}
