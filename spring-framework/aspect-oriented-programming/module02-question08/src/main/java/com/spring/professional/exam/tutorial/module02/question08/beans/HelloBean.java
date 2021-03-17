package com.spring.professional.exam.tutorial.module02.question08.beans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HelloBean {
    public String formatData(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

    public void saveData(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
    }
}
