package com.spring.professional.exam.tutorial.module01.question06.non.web;

import com.spring.professional.exam.tutorial.module01.question06.non.web.beans.SpringBean1;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FileSystemXmlApplicationContextExample {
    public static void main(String[] args) {
        String beansXmlLocationOnFilesystem = FileSystemXmlApplicationContextExample.class.getResource("/beans.xml").toExternalForm();

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(beansXmlLocationOnFilesystem);

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);

        springBean1.sayHello();
    }
}
