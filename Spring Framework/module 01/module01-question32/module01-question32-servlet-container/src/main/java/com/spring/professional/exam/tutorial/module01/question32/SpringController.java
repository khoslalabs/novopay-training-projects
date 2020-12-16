package com.spring.professional.exam.tutorial.module01.question32;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @Value("${app.context.param}")
    private String appContextParam;
    @Value("${app.file.property}")
    private String appFileProperty;
    @Value("${app.vm.property}")
    private String appVmProperty;
    @Value("${user.home}")
    private String userHome;
    @Value("${JAVA_HOME}")
    private String javaHome;
    @Value("${MAVEN_HOME}")
    private String mavenHome;

    @RequestMapping
    @ResponseBody
    public String index() {
        return String.join(
                "<br/>",
                appContextParam,
                appFileProperty,
                appVmProperty,
                userHome,
                javaHome,
                mavenHome
        );
    }
}
