package com.spring.professional.exam.tutorial.module04.question20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws SQLException {
        System.out.println("Printing Data Source URL");
        System.out.println(dataSource.getConnection().getMetaData().getURL());

        System.out.println("Fetching employees e-mails");
        jdbcTemplate.queryForList("select email from employee", String.class)
                .forEach(System.out::println);
    }
}
