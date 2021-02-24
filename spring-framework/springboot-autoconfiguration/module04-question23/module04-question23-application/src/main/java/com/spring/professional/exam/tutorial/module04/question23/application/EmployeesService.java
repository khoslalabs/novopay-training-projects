package com.spring.professional.exam.tutorial.module04.question23.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeesService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printEmails() {
        System.out.println("Fetching employees e-mails");
        jdbcTemplate.queryForList("select email from employee", String.class)
                .forEach(System.out::println);
    }
}
