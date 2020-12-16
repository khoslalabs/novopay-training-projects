package com.spring.professional.exam.tutorial.module01.question25;

import com.spring.professional.exam.tutorial.module01.question25.beans.mappers.DataMapper;
import com.spring.professional.exam.tutorial.module01.question25.beans.processors.DataProcessor;
import com.spring.professional.exam.tutorial.module01.question25.beans.readers.DataReader;
import com.spring.professional.exam.tutorial.module01.question25.beans.writer.DataWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        // Activate profile
        context.getEnvironment().setActiveProfiles("database", "prod");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        System.out.println(context.getBean(DataMapper.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataProcessor.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataReader.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataWriter.class).getClass().getSimpleName());
    }
}
