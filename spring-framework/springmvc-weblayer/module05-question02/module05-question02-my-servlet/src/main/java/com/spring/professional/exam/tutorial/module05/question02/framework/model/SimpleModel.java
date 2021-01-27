package com.spring.professional.exam.tutorial.module05.question02.framework.model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model {
    private Map<String, String> model = new HashMap<>();

    @Override
    public void set(String name, String value) {
        model.put(name, value);
    }

    @Override
    public String get(String name) {
        return model.get(name);
    }
}
