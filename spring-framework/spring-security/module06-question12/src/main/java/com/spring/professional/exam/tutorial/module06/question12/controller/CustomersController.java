package com.spring.professional.exam.tutorial.module06.question12.controller;

import com.spring.professional.exam.tutorial.module06.question12.dao.CustomersDao;
import com.spring.professional.exam.tutorial.module06.question12.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

@Controller
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_READ') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers", "customers", customersDao.findAll());
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_READ') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/view/{customerId}")
    public ModelAndView view(@PathVariable int customerId) {
        return new ModelAndView("customer-view", "customer", customersDao.findById(customerId));
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_CREATE') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/create")
    public ModelAndView create() {
        return new ModelAndView("customer-create", "customer", new Customer());
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_CREATE') || hasRole('ROLE_CUSTOMERS_QA')")
    @PostMapping("/customers/create")
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-create";
        } else {
            customersDao.saveAll(new LinkedList<>(Collections.singletonList(customer)));

            return "redirect:/customers";
        }
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_DELETE') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.deleteAll(
                customersDao.findById(id)
                        .stream()
                        .collect(Collectors.toList())
        );

        return "redirect:/customers";
    }
}
