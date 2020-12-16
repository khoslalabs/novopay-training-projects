package com.spring.professional.exam.tutorial.module01.question24.profiles.activation.programmatically;

import com.spring.professional.exam.tutorial.module01.question24.profiles.activation.programmatically.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        // Activate profile
        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfig.class);
        context.refresh();

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);

        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
