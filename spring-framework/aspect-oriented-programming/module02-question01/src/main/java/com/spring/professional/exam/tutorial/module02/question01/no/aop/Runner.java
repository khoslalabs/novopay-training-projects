package com.spring.professional.exam.tutorial.module02.question01.no.aop;

import com.spring.professional.exam.tutorial.module02.question01.no.aop.actions.ComplexReportAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        ComplexReportAction complexReportAction = context.getBean(ComplexReportAction.class);

        complexReportAction.perform();
    }
}
