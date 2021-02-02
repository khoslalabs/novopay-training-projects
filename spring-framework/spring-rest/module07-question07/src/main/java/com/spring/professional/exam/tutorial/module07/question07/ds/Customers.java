package com.spring.professional.exam.tutorial.module07.question07.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JacksonXmlRootElement(localName = "customers")
public class Customers implements Serializable {

    @JacksonXmlProperty(localName = "customer")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Customer> customers = new LinkedList<>();

    @SuppressWarnings("unused")
    public Customers() {
    }

    public Customers(Iterable<Customer> customers) {
        this.customers = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }
}
