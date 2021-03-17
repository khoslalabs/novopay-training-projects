package com.spring.professional.exam.tutorial.module02.question03.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternateEmployeeRepositoryAspect {
    @Before("execution(* com.spring.professional.exam.tutorial.module02.question03.service.b.AlternateEmployeeRepository.findEmployeeById(..))")
    public void beforeFindEmployeeById() {
        System.out.println("Service B - beforeFindEmployeeById");
    }

    @After("within(com.spring.professional.exam.tutorial.module02.question03.service.b.*)")
    public void afterExecutionWithinPackage() {
        System.out.println("Service B - afterExecutionWithinPackage");
    }
}
