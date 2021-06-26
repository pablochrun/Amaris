package com.example.amaris.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ExtendWith(MockitoExtension.class)
@EnableAutoConfiguration
@ComponentScan( basePackages = {"com.example.amaris"})
@EntityScan( basePackages = {"com.example.amaris"})
@EnableJpaRepositories("com.example.amaris.repository")
public class ApplicationTest{

    @Test
    public void main(){
        Application.main(new String[] {"--spring.profiles.active=test"});
    }

}