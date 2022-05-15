package com.smartservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "javaxmail")
public class MailProperties {

    private String username;
    private String password;

    public MailProperties(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Deprecated
    public MailProperties(){};

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
