package com.smartservice.config.general;

import com.smartservice.config.properties.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailPropertiesConfig {

    @Bean
    public MailProperties mailProperties(){return new MailProperties();}
}
