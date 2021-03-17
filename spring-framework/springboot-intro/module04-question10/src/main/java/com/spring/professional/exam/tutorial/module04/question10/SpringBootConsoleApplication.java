package com.spring.professional.exam.tutorial.module04.question10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private AppConfiguration serverConfiguration;
    @Value("${app.propertyB}")
    private String propertyB;
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(String.format("app.propertyA = %s", serverConfiguration.getPropertyA()));
        System.out.println(String.format("app.propertyB = %s", propertyB));
        System.out.println(String.format("app.propertyC = %s", environment.getProperty("app.propertyC")));
    }
}
