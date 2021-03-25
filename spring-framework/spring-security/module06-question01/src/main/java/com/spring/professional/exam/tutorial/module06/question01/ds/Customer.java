package com.spring.professional.exam.tutorial.module06.question01.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 2, max = 5, message = "Code must have length of 2 - 5 characters")
    @Pattern(regexp = "[A-Za-z]*", message = "Code contains illegal characters")
    private String code;
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
    private String lastName;
    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters")
    private String address;

    @SuppressWarnings("unused")
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
