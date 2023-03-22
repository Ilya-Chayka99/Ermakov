package ru.chay.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    String loop(){
        return "OOP";
    }
}
