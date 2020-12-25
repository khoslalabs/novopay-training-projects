package com.spring.professional.exam.tutorial.module02.question07.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeBeanAspect {
    @Before("execution(* com.spring.professional.exam.tutorial.module02.question07.beans.EmployeeBean.get*()) || execution(* com.spring.professional.exam.tutorial.module02.question07.beans.EmployeeBean.set*(*))")
    public void beforeGetterOrSetter(JoinPoint joinPoint) {
        System.out.println("beforeGetterOrSetter " + joinPoint.getSignature());
    }
}
