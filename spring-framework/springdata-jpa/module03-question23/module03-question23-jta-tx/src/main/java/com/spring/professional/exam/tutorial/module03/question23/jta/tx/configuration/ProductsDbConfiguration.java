package com.spring.professional.exam.tutorial.module03.question23.jta.tx.configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.products.dao"},
        entityManagerFactoryRef = "productsEntityManagerFactory"
)
public class ProductsDbConfiguration {
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean productsEntityManagerFactory(DataSource productsDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJtaDataSource(productsDataSource);
        em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.products.ds");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource productsDataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://localhost:3306/spring-tutorial-products");
        mysqlXADataSource.setUser("spring-tutorial");
        mysqlXADataSource.setPassword("spring-tutorial");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("productsDb");
        return atomikosDataSourceBean;
    }
}
