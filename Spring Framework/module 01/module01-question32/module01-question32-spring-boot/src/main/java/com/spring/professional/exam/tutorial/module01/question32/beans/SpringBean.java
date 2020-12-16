package com.spring.professional.exam.tutorial.module01.question32.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    @Value("${app.default.property}")
    private String appDefaultProperty;
    @Value("${app.dev.property}")
    private String appDevProperty;
    @Value("${app.vm.property}")
    private String appVmProperty;
    @Value("${app.env.property}")
    private String appEnvProperty;
    @Value("${app.json.property}")
    private String appJsonProperty;
    @Value("${app.cli.property}")
    private String appCliProperty;
    @Value("${random.int}")
    private int appRandomProperty;

    public String getAppDefaultProperty() {
        return appDefaultProperty;
    }

    public String getAppDevProperty() {
        return appDevProperty;
    }

    public String getAppVmProperty() {
        return appVmProperty;
    }

    public String getAppEnvProperty() {
        return appEnvProperty;
    }

    public String getAppJsonProperty() {
        return appJsonProperty;
    }

    public String getAppCliProperty() {
        return appCliProperty;
    }

    public int getAppRandomProperty() {
        return appRandomProperty;
    }
}
