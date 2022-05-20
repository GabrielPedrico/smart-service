package com.smartservice.config.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4jConfig {
    @Bean
    public Logger getLogger(){return LoggerFactory.getLogger(Log4jConfig.class);}
}
