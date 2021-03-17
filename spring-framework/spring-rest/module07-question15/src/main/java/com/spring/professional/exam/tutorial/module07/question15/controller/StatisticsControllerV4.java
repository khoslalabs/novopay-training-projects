package com.spring.professional.exam.tutorial.module07.question15.controller;

import com.spring.professional.exam.tutorial.module07.question15.ds.Customer;
import com.spring.professional.exam.tutorial.module07.question15.ds.CustomerStatistics;
import com.spring.professional.exam.tutorial.module07.question15.ds.Statistics;
import com.spring.professional.exam.tutorial.module07.question15.service.CustomerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticsControllerV4 {

    @Autowired
    private CustomerStatisticsService customerStatisticsService;

    // Request with data being present:
    // curl -i -X POST -H 'Content-Type: application/json' -d '{ "code": "CS", "firstName": "Christine", "lastName": "Smart" }' http://localhost:8080/api/v4/calculateStatistics
    //
    // Request without data:
    // curl -i -X POST http://localhost:8080/api/v4/calculateStatistics
    //
    // Request without data against v2 that does not contain 'required = false':
    // curl -i -X POST http://localhost:8080/api/v2/calculateStatistics
    @PostMapping("/api/v4/calculateStatistics")
    @ResponseBody
    public CustomerStatistics getStatistics(@RequestBody(required = false) Customer customer) {
        if (customer != null)
            return new CustomerStatistics(
                    customer, customerStatisticsService.calculcateStatistics(customer)
            );
        else
            return new CustomerStatistics(new Customer(), new Statistics());
    }
}
