package com.spring.professional.exam.tutorial.module03.question21.ds;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private float salary;

   public Employee(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee() {
    }

  @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
