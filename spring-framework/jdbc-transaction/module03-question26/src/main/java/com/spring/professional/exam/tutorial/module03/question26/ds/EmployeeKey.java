package com.spring.professional.exam.tutorial.module03.question26.ds;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeKey implements Serializable {
    private String firstName;
    private String lastName;

    @SuppressWarnings("unused")
    public EmployeeKey() {
    }
}
