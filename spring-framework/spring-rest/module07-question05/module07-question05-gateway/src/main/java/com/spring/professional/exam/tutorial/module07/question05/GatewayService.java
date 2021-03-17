package com.spring.professional.exam.tutorial.module07.question05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayService {

    public static void main(String[] args) {
        SpringApplication.run(GatewayService.class, args);
    }
}
