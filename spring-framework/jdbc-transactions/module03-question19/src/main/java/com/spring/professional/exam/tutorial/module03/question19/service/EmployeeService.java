package com.spring.professional.exam.tutorial.module03.question19.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Transactional
    public void methodWithTransaction() {
        // db related operations
    }
}
