package com.spring.professional.exam.tutorial.module04.question22.mysql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Objects;

@ConfigurationProperties(prefix = "mysql")
public class MySqlProperties {
    private String host;
    private int port;
    private String dbname;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "MySqlProperties{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", dbname='" + dbname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySqlProperties that = (MySqlProperties) o;
        return port == that.port && Objects.equals(host, that.host) && Objects.equals(dbname, that.dbname) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, dbname, username, password);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
