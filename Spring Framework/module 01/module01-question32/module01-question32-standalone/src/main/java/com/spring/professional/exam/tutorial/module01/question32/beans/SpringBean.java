package com.spring.professional.exam.tutorial.module01.question32.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    @Value("${app.file.property}")
    private String appFileProperty;
    @Value("${app.vm.property}")
    private String appVmProperty;
    @Value("${app.env.property}")
    private String appEnvProperty;
    @Value("${user.home}")
    private String userHome;
    @Value("${JAVA_HOME}")
    private String javaHome;
    @Value("${MAVEN_HOME}")
    private String mavenHome;

    public String getAppFileProperty() {
        return appFileProperty;
    }

    public String getAppVmProperty() {
        return appVmProperty;
    }

    public String getAppEnvProperty() {
        return appEnvProperty;
    }

    public String getUserHome() {
        return userHome;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getMavenHome() {
        return mavenHome;
    }
}
