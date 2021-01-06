package com.spring.professional.exam.tutorial.module03.question15.aspectj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    public void transaction1And2() {
        transaction1();
        transaction2();
    }

    @Transactional
    public void transaction1And2WithPrecedingTransaction() {
        transaction1();
        transaction2();
    }

    @Transactional
    public void transaction1() {
        System.out.println("transaction1 method called");
    }

    @Transactional
    public void transaction2() {
        System.out.println("transaction2 method called");
    }
}
