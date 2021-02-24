package com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.java9;

import com.spring.professional.exam.tutorial.module04.question23.auto.configuration.java.JavaEnvInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnJava(JavaVersion.NINE)
public class Java9AutoConfiguration {
    @Bean
    public JavaEnvInfo javaEnvInfo() {
        return new Java9EnvInfo();
    }
}
