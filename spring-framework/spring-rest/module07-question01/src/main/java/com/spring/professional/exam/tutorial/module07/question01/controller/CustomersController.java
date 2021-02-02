package com.spring.professional.exam.tutorial.module07.question01.controller;

import com.spring.professional.exam.tutorial.module07.question01.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question01.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public Iterable<Customer> list() {
        return customersDao.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable int id) {
        return customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Customer savedCustomer = customersDao.save(customer);

            return ResponseEntity
                    .created(URI.create("/customers/" + savedCustomer.getId()))
                    .body(savedCustomer);
        } else
            throw new ResponseStatusException(BAD_REQUEST, String.format("Request contains incorrect data = [%s]", getErrors(bindingResult)));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@RequestBody @Valid Customer customer, @PathVariable int id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (customersDao.existsById(id)) {
                customer.setId(id);
                Customer savedCustomer = customersDao.save(customer);

                return ResponseEntity
                        .ok(savedCustomer);
            } else
                return ResponseEntity.notFound().build();
        } else
            throw new ResponseStatusException(BAD_REQUEST, String.format("Request contains incorrect data = [%s]", getErrors(bindingResult)));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (customersDao.existsById(id)) {
            customersDao.deleteById(id);

            return ResponseEntity.status(NO_CONTENT).build();
        } else
            return ResponseEntity.notFound().build();
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
