package com.spring.professional.exam.tutorial.module02.question07.beans;

import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {
    private int id;
    private String name;
    private String workPhone;
    private String cubicId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getCubicId() {
        return cubicId;
    }

    public void setCubicId(String cubicId) {
        this.cubicId = cubicId;
    }
}
