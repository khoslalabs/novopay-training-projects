package com.spring.professional.exam.tutorial.module07.question15.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Customer {
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

    @SuppressWarnings("unused")
    public Customer() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Customer(@NotBlank @Size(min = 2, max = 5, message = "Code must have length of 2 - 5 characters") @Pattern(regexp = "[A-Za-z]*", message = "Code contains illegal characters") String code, @NotBlank(message = "First name cannot be empty") @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters") String firstName, @NotBlank(message = "Last name cannot be empty") @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters") String lastName) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
