package com.spring.professional.exam.tutorial.module07.question19.api.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@AllArgsConstructor
public class Customers {
    private List<Customer> customers;

    @SuppressWarnings("unused")
    public Customers() {
    }

    public Customers(Spliterator<Customer> spliterator) {
        customers = StreamSupport.stream(spliterator, false)
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
