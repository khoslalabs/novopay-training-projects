package com.spring.professional.exam.tutorial.module01.question34.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SpringBean {

    @Value("${app.file.property}")
    private String appFileProperty;
    @Value("${JAVA_HOME}")
    private String javaHome;
    @Value("${OS}")
    private String osName;

    @Value("#{2 + 2}")
    private int additionResult;
    @Value("#{'New York'.toUpperCase()}")
    private String cityName;
    @Value("#{T(java.time.LocalDateTime).now()}")
    private LocalDateTime currentDate;
    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHomeSpel;

    public String getAppFileProperty() {
        return appFileProperty;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getOsName() {
        return osName;
    }

    public int getAdditionResult() {
        return additionResult;
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public String getJavaHomeSpel() {
        return javaHomeSpel;
    }
}
