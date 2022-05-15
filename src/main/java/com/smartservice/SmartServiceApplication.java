package com.smartservice;

import com.smartservice.config.properties.MailProperties;
import com.smartservice.config.properties.WppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MailProperties.class, WppProperties.class})
public class SmartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartServiceApplication.class, args);
	}

}
