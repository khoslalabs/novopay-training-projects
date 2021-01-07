package com.spring.professional.exam.tutorial.module03.question17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class EmployeeService {

    @Autowired
    private DataSource dataSource;

    @Transactional
    public void declarativeTransaction() {
        // use dao to update data
    }

    public void manualTransaction() throws SQLException {
        Connection connection = dataSource.getConnection();

        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        try {
            // use connection to update data on transaction

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }
}
