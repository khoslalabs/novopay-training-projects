package com.spring.professional.exam.tutorial.module07.question08.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterServiceRequest {
    private int number;

    public CounterServiceRequest(@JsonProperty("number") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
