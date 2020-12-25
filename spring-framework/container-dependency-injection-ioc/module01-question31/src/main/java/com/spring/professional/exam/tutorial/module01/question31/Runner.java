package com.spring.professional.exam.tutorial.module01.question31;

import com.spring.professional.exam.tutorial.module01.question31.beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        //context.getEnvironment().setActiveProfiles("profile1", "profile2", "profile3");
        // -Dspring.profiles.active="profile1,profile2,profile3"

        context.register(ApplicationConfiguration.class);
        context.refresh();

        System.out.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
        System.out.println(context.getEnvironment().getProperty("app.file.property"));
        System.out.println(context.getEnvironment().getProperty("app.vm.property"));
        System.out.println(context.getEnvironment().getProperty("app.env.property"));
        System.out.println(context.getEnvironment().getProperty("user.home"));
        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));
        System.out.println(context.getEnvironment().getProperty("MAVEN_HOME"));

        System.out.println(context.getBean(SpringBean.class).getAppFileProperty());
        System.out.println(context.getBean(SpringBean.class).getAppVmProperty());
        System.out.println(context.getBean(SpringBean.class).getAppEnvProperty());
        System.out.println(context.getBean(SpringBean.class).getUserHome());
        System.out.println(context.getBean(SpringBean.class).getJavaHome());
        System.out.println(context.getBean(SpringBean.class).getMavenHome());
    }
}
