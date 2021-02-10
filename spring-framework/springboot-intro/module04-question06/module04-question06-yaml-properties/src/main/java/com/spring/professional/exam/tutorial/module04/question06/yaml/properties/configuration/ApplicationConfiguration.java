package com.spring.professional.exam.tutorial.module04.question06.yaml.properties.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app")
public class ApplicationConfiguration {
    private String name;
    private String description;
    private List<String> servers;
    private Map<String, EnvironmentConfiguration> environments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public Map<String, EnvironmentConfiguration> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, EnvironmentConfiguration> environments) {
        this.environments = environments;
    }


    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", servers=" + servers +
                ", environments=" + environments +
                '}';
    }
}
