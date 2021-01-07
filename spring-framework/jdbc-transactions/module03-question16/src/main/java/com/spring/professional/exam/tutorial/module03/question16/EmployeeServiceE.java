package com.spring.professional.exam.tutorial.module03.question16;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceE {

    @Transactional
    protected void operationEProtected() {
        System.out.println("Invoked operationEProtected");
    }

    @Transactional
    void operationEPackageVisible() {
        System.out.println("Invoked operationEPackageVisible");
    }

    @Transactional
    private void operationEPrivate() {
        System.out.println("Invoked operationEPrivate");
    }
}
