package com.spring.professional.exam.tutorial.module02.question07.beans;

import com.spring.professional.exam.tutorial.module02.question07.annotation.CustomTransaction;
import com.spring.professional.exam.tutorial.module02.question07.ds.Person;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("hello_child_bean")
public class HelloChildBean extends HelloBean {
    @Override
    public void sayHello(String name, int ex) {
        System.out.println("Hello from Spring Child Bean for " + name);
    }

    public void validateName(String name) throws IOException {
    }

    @CustomTransaction
    public void saveCounterValue(int counterValue) {
    }

    public void savePerson(Person person) {
    }
}
