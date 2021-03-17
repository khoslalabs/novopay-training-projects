package com.spring.professional.exam.tutorial.module07.question18.ds;

public class Customer {
    private String code;
    private String firstName;
    private String lastName;

    public Customer(String code, String firstName, String lastName) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
