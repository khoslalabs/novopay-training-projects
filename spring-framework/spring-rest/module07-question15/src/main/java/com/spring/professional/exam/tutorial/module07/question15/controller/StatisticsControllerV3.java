package com.spring.professional.exam.tutorial.module07.question15.controller;

import com.spring.professional.exam.tutorial.module07.question15.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question15.ds.CustomerStatistics;
import com.spring.professional.exam.tutorial.module07.question15.service.CustomerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class StatisticsControllerV3 {

    @Autowired
    private CustomerStatisticsService customerStatisticsService;

    // Request with valid data:
    // curl -i -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/api/v3/calculateStatistics
    //
    // Request with invalid data:
    // curl -i -X POST -H 'Content-Type: application/json' -d '{ "code": "11", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/api/v3/calculateStatistics
    //
    // Request with invalid data against v2 that does not contain @Valid annotation will not trigger validation:
    // curl -i -X POST -H 'Content-Type: application/json' -d '{ "code": "11", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/api/v2/calculateStatistics
    @PostMapping("/api/v3/calculateStatistics")
    @ResponseBody
    public CustomerStatistics getStatistics(@RequestBody @Valid Customer customer) {
        return new CustomerStatistics(
                customer, customerStatisticsService.calculcateStatistics(customer)
        );
    }
}
