package com.spring.professional.exam.tutorial.module07.question14.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Customer {
    private String code;
    private String firstName;
    private String lastName;

    @SuppressWarnings("unused")
    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer(String code, String firstName, String lastName) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
