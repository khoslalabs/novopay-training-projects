package com.spring.professional.exam.tutorial.module01.question14.beans;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class SpringBean1 implements InitializingBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println(getClass().getSimpleName() + "::postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + "::afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println(getClass().getSimpleName() + "::initMethod");
    }
}
