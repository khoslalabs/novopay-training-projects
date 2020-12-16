package com.spring.professional.exam.tutorial.module01.question07.post.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("%s::postProcessBeforeInitialization %s %s", getClass().getSimpleName(), bean.getClass().getSimpleName(), beanName));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("%s::postProcessAfterInitialization %s %s", getClass().getSimpleName(), bean.getClass().getSimpleName(), beanName));
        return bean;
    }
}
