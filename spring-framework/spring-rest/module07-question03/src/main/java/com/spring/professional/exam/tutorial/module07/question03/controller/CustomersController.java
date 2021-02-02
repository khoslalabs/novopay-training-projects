package com.spring.professional.exam.tutorial.module07.question03.controller;

import com.spring.professional.exam.tutorial.module07.question03.dao.AddressesDao;
import com.spring.professional.exam.tutorial.module07.question03.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module07.question03.ds.Address;
import com.spring.professional.exam.tutorial.module07.question03.ds.Customer;
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
    @Autowired
    private AddressesDao addressesDao;

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
                linkTo(methodOn(CustomersController.class).listAddresses(id)).withRel("addresses"),
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

    @GetMapping("/customers/{id}/addresses")
    public Resources<Resource<Address>> listAddresses(@PathVariable int id) {
        Customer customer = customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<Resource<Address>> addresses = customer.getAddresses().stream()
                .map(address -> new Resource<>(address,
                        linkTo(methodOn(CustomersController.class).getAddress(id, address.getId())).withSelfRel(),
                        linkTo(methodOn(CustomersController.class).getCustomer(address.getCustomer().getId())).withRel("customer"))
                )
                .collect(Collectors.toList());

        return new Resources<>(addresses);
    }

    @PostMapping("/customers/{id}/addresses")
    public Resource<Address> createAddress(@PathVariable int id, @RequestBody @Valid Address address) {
        Customer customer = customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        address.setCustomer(customer);
        address = addressesDao.save(address);

        customer.getAddresses().add(address);

        customer = customersDao.save(customer);

        return new Resource<>(
                address,
                linkTo(methodOn(CustomersController.class).getAddress(customer.getId(), address.getId())).withSelfRel()
        );
    }

    @PutMapping("/customers/{id}/addresses")
    public Resources<Resource<Address>> updateAddresses(@PathVariable int id, @RequestBody @Valid List<Address> addresses) {
        Customer customer = customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<Address> currentForCustomer = customer.getAddresses();
        currentForCustomer.forEach(address -> address.setCustomer(null));
        addressesDao.deleteAll(currentForCustomer);

        addresses.forEach(address -> address.setCustomer(customer));
        Iterable<Address> savedAddresses = addressesDao.saveAll(addresses);

        List<Resource<Address>> resources = StreamSupport.stream(savedAddresses.spliterator(), false)
                .map(address -> new Resource<>(address, linkTo(methodOn(CustomersController.class).getAddress(id, address.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return new Resources<>(
                resources,
                linkTo(methodOn(CustomersController.class).getCustomer(id)).withRel("customer")
        );
    }

    @DeleteMapping("/customers/{customerId}/addresses")
    public ResponseEntity deleteAddresses(@PathVariable int customerId) {
        Customer customer = customersDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<Address> addresses = customer.getAddresses();
        if (addresses.isEmpty())
            throw new ResponseStatusException(NOT_FOUND);

        addresses.forEach(address -> address.setCustomer(null));
        addressesDao.deleteAll(addresses);

        return new ResponseEntity(NO_CONTENT);
    }

    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public Resource<Address> getAddress(@PathVariable int customerId, @PathVariable int addressId) {
        Customer customer = customersDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        Address customerAddress = customer.getAddresses().stream()
                .filter(address -> address.getId().equals(addressId))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return new Resource<>(
                customerAddress,
                linkTo(methodOn(CustomersController.class).getAddress(customerId, customerAddress.getId())).withSelfRel(),
                linkTo(methodOn(CustomersController.class).listAddresses(customerId)).withRel("addresses"),
                linkTo(methodOn(CustomersController.class).getCustomer(customerId)).withRel("customer")
        );
    }

    @PutMapping("/customers/{customerId}/addresses/{addressId}")
    public Resource<Address> updateAddress(@PathVariable int customerId, @PathVariable int addressId, @RequestBody @Valid Address address) {
        Customer customer = customersDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        if (!addressesDao.existsById(addressId))
            throw new ResponseStatusException(NOT_FOUND);

        address.setId(addressId);
        address.setCustomer(customer);

        Address savedAddress = addressesDao.save(address);

        return new Resource<>(
                savedAddress,
                linkTo(methodOn(CustomersController.class).getAddress(customerId, savedAddress.getId())).withSelfRel(),
                linkTo(methodOn(CustomersController.class).getCustomer(customerId)).withRel("customer")
        );
    }

    @DeleteMapping("/customers/{customerId}/addresses/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable int customerId, @PathVariable int addressId) {
        if (!customersDao.existsById(customerId))
            throw new ResponseStatusException(NOT_FOUND);

        Address address = addressesDao.findById(addressId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        address.setCustomer(null);
        addressesDao.delete(address);

        return new ResponseEntity(NO_CONTENT);
    }
}
