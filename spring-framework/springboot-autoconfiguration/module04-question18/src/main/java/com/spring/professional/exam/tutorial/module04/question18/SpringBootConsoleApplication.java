package com.spring.professional.exam.tutorial.module04.question18;

import com.spring.professional.exam.tutorial.module04.question18.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Fetching employees...");
        employeeDao.findAll()
                .forEach(System.out::println);
    }
}
