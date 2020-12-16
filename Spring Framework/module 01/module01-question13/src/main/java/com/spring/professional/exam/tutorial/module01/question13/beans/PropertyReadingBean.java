package com.spring.professional.exam.tutorial.module01.question13.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyReadingBean {

    @Value("${app.env}")
    private String appEnv;
    @Value("${app.envid}")
    private String appEnvId;

    public void printProperties() {
        System.out.println("app.env = " + appEnv);
        System.out.println("app.envid = " + appEnvId);
    }
}
