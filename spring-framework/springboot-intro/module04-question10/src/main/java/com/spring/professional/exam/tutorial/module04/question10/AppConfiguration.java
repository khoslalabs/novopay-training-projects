package com.spring.professional.exam.tutorial.module04.question10;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppConfiguration {
    private String propertyA;

    public String getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(String propertyA) {
        this.propertyA = propertyA;
    }

    @Override
    public String toString() {
        return "AppConfiguration{" +
                "propertyA='" + propertyA + '\'' +
                '}';
    }
}
