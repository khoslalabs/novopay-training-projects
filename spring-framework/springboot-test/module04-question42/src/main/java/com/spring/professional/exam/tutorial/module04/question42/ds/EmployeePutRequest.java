package com.spring.professional.exam.tutorial.module04.question42.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


public class EmployeePutRequest {
    private String name;
    private String city;

    @SuppressWarnings("unused")
    public EmployeePutRequest() {
    }

    public EmployeePutRequest(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePutRequest that = (EmployeePutRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "EmployeePutRequest{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
