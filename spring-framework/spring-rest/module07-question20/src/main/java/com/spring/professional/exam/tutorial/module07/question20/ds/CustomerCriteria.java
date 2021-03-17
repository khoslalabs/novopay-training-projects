package com.spring.professional.exam.tutorial.module07.question20.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


@AllArgsConstructor
public class CustomerCriteria {
    private String firstNameLike;

    @SuppressWarnings("unused")
    public CustomerCriteria() {
    }

    public String getFirstNameLike() {
        return firstNameLike;
    }

    public void setFirstNameLike(String firstNameLike) {
        this.firstNameLike = firstNameLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCriteria that = (CustomerCriteria) o;
        return Objects.equals(firstNameLike, that.firstNameLike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNameLike);
    }

    @Override
    public String toString() {
        return "CustomerCriteria{" +
                "firstNameLike='" + firstNameLike + '\'' +
                '}';
    }
}
