package com.spring.professional.exam.tutorial.module02.question05.ds;

public class Employee {
    private long id;

    public Employee(long id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}
