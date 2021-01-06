package com.spring.professional.exam.tutorial.module03.question17.aspect;

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
        Object returnValue = null;
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            System.out.println("Starting " + methodName);
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(String.format("Exception thrown from %s: %s", methodName, throwable.getMessage()));
        }

        System.out.println("Completed " + methodName);
        return returnValue;
    }
}
