package com.spring.professional.exam.tutorial.module01.question07.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean1 implements InitializingBean, DisposableBean {

    private SpringBean2 springBean2;

    public SpringBean1() {
        System.out.println("\nCreating " + getClass().getSimpleName());
    }

    public void sayHello() {
        System.out.println("\nHello\n");
    }

    @Autowired
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println("settingProperty on " + getClass().getSimpleName() + " to inject " + springBean2.getClass().getSimpleName());
        this.springBean2 = springBean2;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy " + getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet " + getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy " + getClass().getSimpleName());
    }

    private void initMethod() {
        System.out.println("@Bean(initMethod) " + getClass().getSimpleName());
    }

    private void destroyMethod() {
        System.out.println("@Bean(destroyMethod) " + getClass().getSimpleName());
    }
}
