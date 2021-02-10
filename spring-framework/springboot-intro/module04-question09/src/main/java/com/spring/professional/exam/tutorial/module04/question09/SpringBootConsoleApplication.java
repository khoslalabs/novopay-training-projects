package com.spring.professional.exam.tutorial.module04.question09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private ServerConfiguration serverConfiguration;

    // use --spring.profiles.active=dev or application.properties to set active spring profile
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(serverConfiguration);
    }
}
