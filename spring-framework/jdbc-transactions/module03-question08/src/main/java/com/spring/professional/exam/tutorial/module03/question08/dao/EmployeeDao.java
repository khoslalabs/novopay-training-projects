package com.spring.professional.exam.tutorial.module03.question08.dao;

import com.spring.professional.exam.tutorial.module03.question08.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee", this::mapEmployee);
    }

    public void deleteAllEmployees() {
        int numberOfDeletedRows = jdbcTemplate.update("delete from employee");

        System.out.println(String.format("Employees deleted, number of deleted rows = [%d]", numberOfDeletedRows));
    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() < 0)
            throw new IllegalArgumentException("Employee Id has to be greater than zero");

        int numberOfRecordsInserted = jdbcTemplate.update(
                "insert into employee(employee_id, first_name, last_name, email, phone_number, hire_date, salary) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary()
        );

        if (numberOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.getId()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordsInserted));
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
