package com.spring.professional.exam.tutorial.module04.question22.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(MySqlProperties.class)
@ConditionalOnClass({com.mysql.cj.jdbc.Driver.class})
@PropertySource("classpath:mysql.properties")
public class MySqlAutoConfiguration {
    @Autowired
    private MySqlProperties mySqlProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = getConfiguredDataSource();

        initializeDataSource(dataSource);

        return dataSource;
    }

    private DriverManagerDataSource getConfiguredDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(String.format("jdbc:mysql://%s:%d/%s", mySqlProperties.getHost(), mySqlProperties.getPort(), mySqlProperties.getDbname()));
        dataSource.setUsername(mySqlProperties.getUsername());
        dataSource.setPassword(mySqlProperties.getPassword());

        return dataSource;
    }

    private void initializeDataSource(DriverManagerDataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("mysql-schema.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("mysql-data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }
}
