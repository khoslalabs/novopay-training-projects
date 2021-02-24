package com.spring.professional.exam.tutorial.module04.question19.application;

import com.spring.professional.exam.tutorial.module04.question19.application.service.ServiceA;
import com.spring.professional.exam.tutorial.module04.question19.extra.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackageClasses = {SpringBootConsoleApplication.class, ServiceB.class})
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private ServiceA serviceA;
    //@Autowired
   // private ServiceB serviceB;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }
}
