package com.spring.professional.exam.tutorial.module07.question19.api.controller;

import com.spring.professional.exam.tutorial.module07.question19.api.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question19.api.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question19.api.ds.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api")
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public Customers listCustomers() {
        return new Customers(customersDao.findAll().spliterator());
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customersDao.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity createCustomer(@PathVariable int id) {
        if (customersDao.existsById(id)) {
            customersDao.deleteById(id);
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }
}
