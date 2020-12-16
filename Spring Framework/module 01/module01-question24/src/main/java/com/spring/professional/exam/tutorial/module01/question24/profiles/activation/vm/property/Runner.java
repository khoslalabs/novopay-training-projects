package com.spring.professional.exam.tutorial.module01.question24.profiles.activation.vm.property;

import com.spring.professional.exam.tutorial.module01.question24.profiles.activation.vm.property.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        // profile should be activated with VM property -Dspring.profiles.active=database

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);

        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
