package com.spring.professional.exam.tutorial.module03.question09;

import com.spring.professional.exam.tutorial.module03.question09.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private EmployeesService employeesService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeesService.saveEmployeeWithoutTransaction();
        employeesService.saveEmployeeInTransaction();
    }
}
