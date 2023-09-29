package ru.yakimov.example.spring;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;

@SpringBootApplication
public class Application {

    @Autowired
    private R2dbcProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void printConfiguration() {
        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.info("Max Pool size: {}", properties.getPool().getMaxSize());
        logger.info("Initial Pool size: {}", properties.getPool().getInitialSize());
    }

}
