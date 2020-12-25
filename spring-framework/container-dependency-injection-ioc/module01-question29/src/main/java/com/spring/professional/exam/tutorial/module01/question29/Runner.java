package com.spring.professional.exam.tutorial.module01.question29;

import com.spring.professional.exam.tutorial.module01.question29.beans.SpringBean1;
import com.spring.professional.exam.tutorial.module01.question29.beans.SpringBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        SpringBean2 springBean2 = context.getBean(SpringBean2.class);

        System.out.println("getName = " + springBean1.getName());
        System.out.println("getStreetName = " + springBean1.getStreetName());
        System.out.println("isAccountExists = " + springBean1.isAccountExists());
        System.out.println("getIdNumber = " + springBean1.getIdNumber());
        System.out.println("getAccountBalance = " + springBean1.getAccountBalance());
        System.out.println("getDepartmentId = " + springBean1.getDepartmentId());
        System.out.println("getDepartmentName = " + springBean1.getDepartmentName());
        System.out.println("getManagerName = " + springBean1.getManagerName());
        System.out.println("getSupportContactMail = " + springBean1.getSupportContactMail());
        System.out.println("getSupportPhone = " + springBean1.getSupportPhone());
        System.out.println("getSupportAddress = " + springBean1.getSupportAddress());
        System.out.println("getDependentDepartments = " + Arrays.toString(springBean1.getDependentDepartments()));
        System.out.println("getCasesIds = " + springBean1.getCasesIds());
        System.out.println("getCasesSet = " + springBean1.getCasesSet());
        System.out.println("getCasesMap = " + springBean1.getCasesMap());
        System.out.println("getTaxId = " + springBean1.getTaxId());

        System.out.println("getTaxValue = " + springBean2.getTaxValue());
        System.out.println("getTaxDepartmentName = " + springBean2.getTaxDepartmentName());
        System.out.println("getTaxDepartmentAlternateName = " + springBean2.getTaxDepartmentAlternateName());
    }
}
