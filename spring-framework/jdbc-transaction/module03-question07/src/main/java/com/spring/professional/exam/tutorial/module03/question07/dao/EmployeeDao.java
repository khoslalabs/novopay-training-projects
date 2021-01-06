package com.spring.professional.exam.tutorial.module03.question07.dao;

import com.spring.professional.exam.tutorial.module03.question07.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findEmployeeEmail(int id) {
        return jdbcTemplate.queryForObject("select email from employee where employee_id = ?", new Object[]{id}, String.class);
    }

    public List<String> findEmployeesNames() {
        return jdbcTemplate.queryForList("select first_name from employee", String.class);
    }

    public Map<String, Object> findEmployeeById(int id) {
        return jdbcTemplate.queryForMap("select * from employee where employee_id = ?", id);
    }

    public SqlRowSet findEmployeesRowSet() {
        return jdbcTemplate.queryForRowSet("select * from employee");
    }

    public Employee findEmployee(int id) {
        return jdbcTemplate.queryForObject("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee where employee_id = ?", new Object[]{id}, this::mapEmployee);
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee", this::mapEmployee);
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int i) {
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
