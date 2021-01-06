package com.spring.professional.exam.tutorial.module03.question18.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {
    @Pointcut("within(com..service.*)")
    public void callTraceComponentsPointcut() {
    }

    @Around("callTraceComponentsPointcut()")
    public Object traceCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();

        System.out.println("Starting " + methodName);
        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("Completed " + methodName);
        return returnValue;
    }
}
