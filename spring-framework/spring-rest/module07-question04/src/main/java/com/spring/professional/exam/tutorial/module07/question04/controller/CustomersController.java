package com.spring.professional.exam.tutorial.module07.question04.controller;

import com.spring.professional.exam.tutorial.module07.question04.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question04.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public Resources<Resource<Customer>> listCustomers() {
        List<Resource<Customer>> customers = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(customer -> new Resource<>(customer, linkTo(methodOn(CustomersController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return new Resources<>(
                customers,
                linkTo(methodOn(IndexController.class).index()).withRel("index")
        );
    }

    @PostMapping("/customers")
    public Resource<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        Customer createdCustomer = customersDao.save(customer);

        return new Resource<>(
                createdCustomer,
                linkTo(methodOn(CustomersController.class).getCustomer(customer.getId())).withSelfRel()
        );
    }

    @PutMapping("/customers")
    public Resources<Resource<Customer>> updateCustomers(@RequestBody @Valid Collection<Customer> customers) {
        customersDao.deleteAll();
        Iterable<Customer> updatedCustomers = customersDao.saveAll(customers);

        List<Resource<Customer>> customerResources = StreamSupport.stream(updatedCustomers.spliterator(), false)
                .map(customer -> new Resource<>(customer, linkTo(methodOn(CustomersController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return new Resources<>(
                customerResources,
                linkTo(methodOn(CustomersController.class).listCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers")
    public ResponseEntity deleteCustomers() {
        if (customersDao.count() > 0) {
            customersDao.deleteAll();
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }

    @GetMapping("/customers/{id}")
    public Resource<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return new Resource<>(
                customer,
                linkTo(methodOn(CustomersController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomersController.class).listCustomers()).withRel("customers")
        );
    }

    @PutMapping("/customers/{id}")
    public Resource<Customer> updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer) {

        customer.setId(id);
        Customer savedCustomer = customersDao.save(customer);

        return new Resource<>(
                savedCustomer,
                linkTo(methodOn(CustomersController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomersController.class).listCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        if (customersDao.existsById(id)) {
            customersDao.deleteById(id);
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }
}
