package com.spring.professional.exam.tutorial.module01.question13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:/app-defaults.properties")
public class ApplicationConfiguration {
    @Bean
    public static CustomBeanFactoryPostProcessor customerBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
