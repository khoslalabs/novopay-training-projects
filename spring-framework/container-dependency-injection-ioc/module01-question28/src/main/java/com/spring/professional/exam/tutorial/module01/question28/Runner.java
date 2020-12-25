package com.spring.professional.exam.tutorial.module01.question28;

import com.spring.professional.exam.tutorial.module01.question28.beans.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        SpringBean springBean = context.getBean(SpringBean.class);

        System.out.println("getName = " + springBean.getName());
        System.out.println("getStreetName = " + springBean.getStreetName());
        System.out.println("isAccountExists = " + springBean.isAccountExists());
        System.out.println("getIdNumber = " + springBean.getIdNumber());
        System.out.println("getAccountBalance = " + springBean.getAccountBalance());
        System.out.println("getDepartmentId = " + springBean.getDepartmentId());
        System.out.println("getDepartmentName = " + springBean.getDepartmentName());
        System.out.println("getManagerName = " + springBean.getManagerName());
        System.out.println("getSupportContactMail = " + springBean.getSupportContactMail());
        System.out.println("getSupportPhone = " + springBean.getSupportPhone());
        System.out.println("getSupportAddress = " + springBean.getSupportAddress());
        System.out.println("getDependentDepartments = " + Arrays.toString(springBean.getDependentDepartments()));
        System.out.println("getCasesIds = " + springBean.getCasesIds());
        System.out.println("getCasesSet = " + springBean.getCasesSet());
        System.out.println("getCasesMap = " + springBean.getCasesMap());
    }
}
