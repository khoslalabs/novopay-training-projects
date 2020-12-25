package com.spring.professional.exam.tutorial.module01.question19.proxy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class ApplicationConfig {
    @Bean
    SpringBean springBean() {
        System.out.println("Creating SpringBean in " + getClass().getSimpleName());

        return new SpringBean();
    }
}
