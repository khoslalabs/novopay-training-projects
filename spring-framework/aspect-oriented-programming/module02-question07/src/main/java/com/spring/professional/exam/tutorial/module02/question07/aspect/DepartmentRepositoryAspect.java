package com.spring.professional.exam.tutorial.module02.question07.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DepartmentRepositoryAspect {
    @Before("@within(com.spring.professional.exam.tutorial.module02.question07.annotation.MonitoredRepository)")
    public void annotationWithinExample() {
        System.out.println("Before - annotationWithinExample");
    }

    @Before("@target(com.spring.professional.exam.tutorial.module02.question07.annotation.MonitoredRepository)")
    public void annotationTargetExample() {
        System.out.println("Before - annotationTargetExample");
    }
}
