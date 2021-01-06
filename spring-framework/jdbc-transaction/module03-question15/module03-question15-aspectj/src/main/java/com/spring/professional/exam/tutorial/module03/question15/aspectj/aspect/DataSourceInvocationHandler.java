package com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DataSourceInvocationHandler implements InvocationHandler {

    private DataSource dataSource;

    public DataSourceInvocationHandler(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnObject = method.invoke(dataSource, args);

        if (method.getName().equals("getConnection"))
            System.out.println("Connection Trace: " + method.toGenericString());

        if (returnObject instanceof Connection) {
            return createConnectionProxy((Connection) returnObject);
        } else
            return returnObject;
    }

    private Connection createConnectionProxy(Connection connection) {
        return (Connection) Proxy.newProxyInstance(
                DataSourceProxyFactory.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }
}
