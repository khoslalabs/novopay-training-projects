package com.spring.professional.exam.tutorial.module04.question42.ds;

import com.spring.professional.exam.tutorial.module04.question42.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


public class Employees {
    private Iterable<Employee> employees;

    @SuppressWarnings("unused")
    public Employees() {
    }

    public Employees(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public Iterable<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Iterable<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees1 = (Employees) o;
        return Objects.equals(employees, employees1.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
