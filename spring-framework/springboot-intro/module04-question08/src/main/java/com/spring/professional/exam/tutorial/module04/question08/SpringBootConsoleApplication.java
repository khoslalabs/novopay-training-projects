package com.spring.professional.exam.tutorial.module04.question08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private AppConfiguration appConfiguration;

    // launch with --spring.profiles.active=dev and working directory pointing to work-dir
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(appConfiguration);
    }
}
