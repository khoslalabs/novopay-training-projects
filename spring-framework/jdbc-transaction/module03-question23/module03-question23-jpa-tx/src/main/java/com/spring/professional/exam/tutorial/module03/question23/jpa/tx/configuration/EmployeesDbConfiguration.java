package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.dao"},
        entityManagerFactoryRef = "employeesEntityManagerFactory",
        transactionManagerRef = "employeesTransactionManager"
)
public class EmployeesDbConfiguration {
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean employeesEntityManagerFactory(DataSource employeesDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(employeesDataSource);
        em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.ds");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager employeesTransactionManager(EntityManagerFactory employeesEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(employeesEntityManagerFactory);

        return transactionManager;
    }

    @Bean
    public DataSource employeesDataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("schema-employees.sql")
                .build();
    }
}
