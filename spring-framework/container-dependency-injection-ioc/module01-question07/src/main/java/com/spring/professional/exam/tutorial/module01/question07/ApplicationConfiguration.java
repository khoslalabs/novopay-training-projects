package com.spring.professional.exam.tutorial.module01.question07;

import com.spring.professional.exam.tutorial.module01.question07.beans.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }
}
