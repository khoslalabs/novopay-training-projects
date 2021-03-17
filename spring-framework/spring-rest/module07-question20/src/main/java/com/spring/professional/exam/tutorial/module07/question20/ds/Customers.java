package com.spring.professional.exam.tutorial.module07.question20.ds;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class Customers {
    private List<Customer> customers = new LinkedList<>();

    @SuppressWarnings("unused")
    public Customers() {
    }

    public Customers(Iterable<Customer> customers) {
        this.customers = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers1 = (Customers) o;
        return Objects.equals(customers, customers1.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }
}
