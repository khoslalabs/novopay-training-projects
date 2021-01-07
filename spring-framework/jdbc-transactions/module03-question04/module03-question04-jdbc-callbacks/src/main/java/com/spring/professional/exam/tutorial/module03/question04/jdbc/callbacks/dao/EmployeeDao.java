package com.spring.professional.exam.tutorial.module03.question04.jdbc.callbacks.dao;

import com.spring.professional.exam.tutorial.module03.question04.jdbc.callbacks.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        return new Employee(
                                resultSet.getInt("employee_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"),
                                resultSet.getDate("hire_date"),
                                resultSet.getFloat("salary")
                        );
                    }
                }
        );
    }

    public float findAverageSalaryRowByRow() {
        AverageSalaryRowCallbackHandler averageSalaryRowCallbackHandler = new AverageSalaryRowCallbackHandler();

        jdbcTemplate.query(
                "select salary from employee",
                averageSalaryRowCallbackHandler
        );

        return averageSalaryRowCallbackHandler.getAverageSalary();
    }

    public Float findAverageSalaryCalculatedOnEntireResultSet() {
        return jdbcTemplate.query(
                "select salary from employee",
                new AverageSalaryResultSetExtractor()
        );
    }

    public double findAverageSalaryModernImplementation() {
        return jdbcTemplate.queryForList(
                "select salary from employee",
                Double.class
        ).stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0f);
    }

    public double findAverageSalarySqlLevel() {
        return jdbcTemplate.queryForObject(
                "select avg(salary) from employee",
                Double.class
        );
    }

    public int findEmployeeIdFromEmail(String email) {
        return jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("select employee_id from employee where email = ?");
                    }
                },
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, email);
                    }
                },
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next())
                            return rs.getInt("employee_id");
                        else
                            throw new SQLException("Unable to find id based on email");
                    }
                }
        );
    }

    private static class AverageSalaryRowCallbackHandler implements RowCallbackHandler {
        private float salarySum = 0;
        private int salariesCount = 0;

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            salarySum += rs.getFloat("salary");
            ++salariesCount;
        }

        public float getAverageSalary() {
            return salarySum / (float) salariesCount;
        }
    }

    private static class AverageSalaryResultSetExtractor implements ResultSetExtractor<Float> {
        @Override
        public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
            float salarySum = 0;
            int salariesCount = 0;

            while (rs.next()) {
                salarySum += rs.getFloat("salary");
                ++salariesCount;
            }

            return salarySum / (float) salariesCount;
        }
    }
}
