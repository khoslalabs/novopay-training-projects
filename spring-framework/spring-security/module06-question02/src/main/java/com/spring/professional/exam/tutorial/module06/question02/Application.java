package com.spring.professional.exam.tutorial.module06.question02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // Spring Security Code Places to analyze:
    // DelegatingFilterProxy.doFilter
    // FilterChainProxy.doFilterInternal
    // ProviderManager.authenticate
    // AffirmativeBased.decide
    // RoleVoter.vote
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
