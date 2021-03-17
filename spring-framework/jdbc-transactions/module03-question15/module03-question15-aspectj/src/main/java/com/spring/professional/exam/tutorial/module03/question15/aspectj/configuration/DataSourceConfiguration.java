package com.spring.professional.exam.tutorial.module03.question15.aspectj.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect.DataSourceProxyFactory.createDataSourceProxy;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        return createDataSourceProxy(new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .build());
    }

    @Bean
    @Autowired
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
