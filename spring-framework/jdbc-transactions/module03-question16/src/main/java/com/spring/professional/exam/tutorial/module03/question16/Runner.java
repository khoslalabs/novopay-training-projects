package com.spring.professional.exam.tutorial.module03.question16;

import com.spring.professional.exam.tutorial.module03.question16.service.EmployeeServiceA;
import com.spring.professional.exam.tutorial.module03.question16.service.EmployeeServiceB;
import com.spring.professional.exam.tutorial.module03.question16.service.EmployeeServiceC;
import com.spring.professional.exam.tutorial.module03.question16.service.EmployeeServiceD;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeServiceA employeeServiceA = context.getBean(EmployeeServiceA.class);
        EmployeeServiceB employeeServiceB = context.getBean(EmployeeServiceB.class);
        EmployeeServiceC employeeServiceC = context.getBean(EmployeeServiceC.class);
        EmployeeServiceD employeeServiceD = context.getBean(EmployeeServiceD.class);
        EmployeeServiceE employeeServiceE = context.getBean(EmployeeServiceE.class);

        employeeServiceA.operationA();
        employeeServiceB.operationB();
        employeeServiceC.operationC();
        employeeServiceD.operationD();

        employeeServiceE.operationEProtected();
        employeeServiceE.operationEPackageVisible();
        Method operationEPrivate = EmployeeServiceE.class.getDeclaredMethod("operationEPrivate");
        operationEPrivate.setAccessible(true);
        operationEPrivate.invoke(employeeServiceE);
    }
}
