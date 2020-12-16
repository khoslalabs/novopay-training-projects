package com.spring.professional.exam.tutorial.module01.question20.xml.context;

import com.spring.professional.exam.tutorial.module01.question20.xml.context.beans.SpringBean1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.printDependencies();
    }
}
