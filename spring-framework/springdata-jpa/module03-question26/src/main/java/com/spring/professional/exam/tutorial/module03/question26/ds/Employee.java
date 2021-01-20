package com.spring.professional.exam.tutorial.module03.question26.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;


@Getter
@Setter
@Entity
public class Employee {
    @EmbeddedId
    private EmployeeKey employeeKey;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private float salary;

    @SuppressWarnings("unused")
    public Employee() {
    }

    public Employee(com.spring.professional.exam.tutorial.module03.question26.ds.EmployeeKey employeeKey, String email, String phoneNumber, Date hireDate, float salary) {
        this.employeeKey = employeeKey;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}
