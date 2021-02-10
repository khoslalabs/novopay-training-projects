package com.spring.professional.exam.tutorial.module04.question06.yaml.properties.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class EnvironmentConfiguration {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EnvironmentConfiguration{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
