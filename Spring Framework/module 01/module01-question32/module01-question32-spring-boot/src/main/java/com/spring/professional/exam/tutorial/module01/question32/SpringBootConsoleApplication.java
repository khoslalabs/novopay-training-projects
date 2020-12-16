package com.spring.professional.exam.tutorial.module01.question32;

import com.spring.professional.exam.tutorial.module01.question32.beans.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private SpringBean springBean;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("getAppDefaultProperty: " + springBean.getAppDefaultProperty());
        System.out.println("getAppDevProperty: " + springBean.getAppDevProperty());
        System.out.println("getAppVmProperty: " + springBean.getAppVmProperty());
        System.out.println("getAppEnvProperty: " + springBean.getAppEnvProperty());
        System.out.println("getAppJsonProperty: " + springBean.getAppJsonProperty());
        System.out.println("getAppCliProperty: " + springBean.getAppCliProperty());
        System.out.println("getAppRandomProperty: " + springBean.getAppRandomProperty());
    }
}
