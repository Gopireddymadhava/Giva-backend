package com.exception;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@EntityScan(basePackages = "com.exception.*")
@EnableJpaRepositories(basePackages = "com.exception.*")
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.exception.*")


@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class GivaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GivaApplication.class, args);
	}

}
