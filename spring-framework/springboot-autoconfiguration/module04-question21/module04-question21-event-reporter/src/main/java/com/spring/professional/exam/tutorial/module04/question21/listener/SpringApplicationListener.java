package com.spring.professional.exam.tutorial.module04.question21.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SpringApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Application Event Received = " + event);
    }
}
