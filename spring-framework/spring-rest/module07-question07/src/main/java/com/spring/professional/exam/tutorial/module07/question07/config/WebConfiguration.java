package com.spring.professional.exam.tutorial.module07.question07.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // register HttpMessageConverters
        // When using Spring Boot, most HttpMessageConverter will be registered automatically.
        // Automatic registration is implemented in HttpMessageConvertersAutoConfiguration,
        // and default list of converters is created inside WebMvcConfigurationSupport.addDefaultHttpMessageConverters
    }
}
