package com.spring.professional.exam.tutorial.module01.question06.boot.cli.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean1 {
    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    @Autowired
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean2");
        this.springBean2 = springBean2;
    }

    @Autowired
    public void setSpringBean3(SpringBean3 springBean3) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean3");
        this.springBean3 = springBean3;
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + "::init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + "::destroy");
    }
}
