package com.spring.professional.exam.tutorial.module03.question14.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.*;

@Repository
public class EmployeeDao {
    @Transactional(propagation = REQUIRED)
    public void requiredTransactionMethod() {
    }

    @Transactional(propagation = SUPPORTS)
    public void supportsTransactionMethod() {
    }

    @Transactional(propagation = MANDATORY)
    public void mandatoryTransactionMethod() {
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void requiresNewTransactionMethod() {
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public void notSupportedTransactionMethod() {
    }

    @Transactional(propagation = NEVER)
    public void neverTransactionMethod() {
    }

    @Transactional(propagation = NESTED)
    public void nestedTransactionMethod() {
    }
}
