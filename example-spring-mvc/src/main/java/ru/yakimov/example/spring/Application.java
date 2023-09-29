package ru.yakimov.example.spring;

import org.jdbi.v3.core.Jdbi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        return Jdbi.create(new TransactionAwareDataSourceProxy(dataSource));
    }

}
