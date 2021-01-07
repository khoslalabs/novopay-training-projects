package com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;

public class DataSourceProxyFactory {
    public static DataSource createDataSourceProxy(DataSource dataSource) {
        return (DataSource) Proxy.newProxyInstance(
                DataSourceProxyFactory.class.getClassLoader(),
                new Class[]{DataSource.class},
                new DataSourceInvocationHandler(dataSource)
        );
    }
}
