package com.example.amaris.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan( basePackages = {"com.example.amaris"})
@EntityScan( basePackages = {"com.example.amaris"})
@EnableJpaRepositories("com.example.amaris.repository")
public class Application{
    public static void main (String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
