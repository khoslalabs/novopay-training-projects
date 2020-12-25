package com.spring.professional.exam.tutorial.module01.question09.boot;

import com.spring.professional.exam.tutorial.module01.question09.boot.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private SpringBean1 springBean1;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        springBean1.sayHello();
    }
}
