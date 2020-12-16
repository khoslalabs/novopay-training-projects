package com.spring.professional.exam.tutorial.module01.question10.stereotypes;


import com.spring.professional.exam.tutorial.module01.question10.stereotypes.controller.TaxInformationController;
import com.spring.professional.exam.tutorial.module01.question10.stereotypes.ds.Article;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.registerShutdownHook();

        TaxInformationController taxInformationController = context.getBean(TaxInformationController.class);
        taxInformationController.printTaxInformation(new Article(5));
    }
}
