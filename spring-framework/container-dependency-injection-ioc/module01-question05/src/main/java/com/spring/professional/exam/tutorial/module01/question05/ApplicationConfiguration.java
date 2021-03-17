package com.spring.professional.exam.tutorial.module01.question05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ApplicationConfiguration {
    @Bean
    public static CustomBeanFactoryPostProcessor getCustomBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor getCustomerBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
