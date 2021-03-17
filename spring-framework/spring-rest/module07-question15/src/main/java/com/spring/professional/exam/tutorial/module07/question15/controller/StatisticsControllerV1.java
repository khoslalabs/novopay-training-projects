package com.spring.professional.exam.tutorial.module07.question15.controller;

import com.spring.professional.exam.tutorial.module07.question15.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question15.ds.CustomerStatistics;
import com.spring.professional.exam.tutorial.module07.question15.service.CustomerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticsControllerV1 {

    @Autowired
    private CustomerStatisticsService customerStatisticsService;

    // curl -v -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/api/v1/calculateStatistics
    @PostMapping("/api/v1/calculateStatistics")
    @ResponseBody
    public CustomerStatistics getStatistics(@RequestBody Customer customer) {
        return new CustomerStatistics(
                customer, customerStatisticsService.calculcateStatistics(customer)
        );
    }
}
