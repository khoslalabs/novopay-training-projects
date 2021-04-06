package com.spring.professional.exam.tutorial.module06.question12.dao;

import com.spring.professional.exam.tutorial.module06.question12.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.Optional;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
    @PreFilter("hasRole('ROLE_CUSTOMERS_CREATE') || (hasRole('ROLE_CUSTOMERS_QA') && filterObject.firstName.equals('TEST'))")
    @Override
    <S extends Customer> Iterable<S> saveAll(Iterable<S> entities);

    @PostFilter("hasRole('ROLE_CUSTOMERS_READ') || (hasRole('ROLE_CUSTOMERS_QA') && filterObject.firstName.equals('TEST'))")
    @Override
    Iterable<Customer> findAll();

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_DELETE') || (hasRole('ROLE_CUSTOMERS_QA') && entity.firstName.equals('TEST'))")
    @Override
    void delete(Customer entity);

    @PostAuthorize("hasRole('ROLE_CUSTOMERS_READ') || (hasRole('ROLE_CUSTOMERS_QA') && returnObject.isPresent() && returnObject.get().firstName.equals('TEST'))")
    @Override
    Optional<Customer> findById(Integer integer);
}
