package com.spring.professional.exam.tutorial.module01.question04;

import com.spring.professional.exam.tutorial.module01.question04.beans.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String... args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            Car car = context.getBean(Car.class);

            car.drive();
        }
    }
}
