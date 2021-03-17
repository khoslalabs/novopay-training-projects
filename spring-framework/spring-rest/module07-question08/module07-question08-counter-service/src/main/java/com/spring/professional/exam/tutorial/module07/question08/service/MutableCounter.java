package com.spring.professional.exam.tutorial.module07.question08.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MutableCounter {
    private int number;

    public int getNumber() {
        return number;
    }

    public void countUp() {
        ++number;
    }
}
