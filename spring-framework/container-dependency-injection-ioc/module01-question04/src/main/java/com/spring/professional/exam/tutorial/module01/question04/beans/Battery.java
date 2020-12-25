package com.spring.professional.exam.tutorial.module01.question04.beans;

import org.springframework.stereotype.Component;

@Component
class Battery {
    void supplyPower() {
        System.out.println("Supplying power");
    }
}
