package com.spring.professional.exam.tutorial.module07.question12.controller;

import com.spring.professional.exam.tutorial.module07.question12.annotation.RestEndpoint;
import com.spring.professional.exam.tutorial.module07.question12.dao.AddressesDao;
import com.spring.professional.exam.tutorial.module07.question12.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question12.ds.Address;
import com.spring.professional.exam.tutorial.module07.question12.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestEndpoint
@RequestMapping("/api/v4")
public class ApiControllerV4 {

    @Autowired
    private CustomersDao customersDao;
    @Autowired
    private AddressesDao addressesDao;

    // curl localhost:8080/api/v4/customers |jq
    @GetMapping("customers")
    public Iterable<Customer> listCustomers() {
        return customersDao.findAll();
    }

    // curl localhost:8080/api/v4/addresses |jq
    @GetMapping("addresses")
    public Iterable<Address> listAddresses() {
        return addressesDao.findAll();
    }
}
