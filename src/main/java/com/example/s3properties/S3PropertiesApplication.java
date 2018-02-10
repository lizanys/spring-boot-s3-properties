package com.example.s3properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("${properties.location}")
@EnableConfigurationProperties(S3Properties.class)
public class S3PropertiesApplication {

    @Autowired
    private S3Properties properties;

    public static void main(String[] args) {
        SpringApplication.run(S3PropertiesApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> System.out.println("properties = " + properties);
    }
}
