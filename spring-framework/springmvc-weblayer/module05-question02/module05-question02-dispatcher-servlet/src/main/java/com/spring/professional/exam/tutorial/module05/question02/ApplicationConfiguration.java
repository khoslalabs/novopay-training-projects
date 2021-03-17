package com.spring.professional.exam.tutorial.module05.question02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@ComponentScan
public class ApplicationConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver springTemplateResolver() {
        SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
        springTemplateResolver.setApplicationContext(applicationContext);
        springTemplateResolver.setPrefix("/WEB-INF/views/");
        springTemplateResolver.setSuffix(".html");
        return springTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springTemplateResolver());
        return springTemplateEngine;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(springTemplateEngine());
        return viewResolver;
    }
}
