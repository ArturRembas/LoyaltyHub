package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

/**
 * DatabaseConfig class is responsible for configuring the database connection
 * and setting up the necessary Hibernate properties for the application.
 *
 * This class is annotated with @Configuration, which indicates that it provides
 * one or more @Bean methods and may be processed by the Spring container to
 * generate bean definitions and service requests for those beans at runtime.
 *
 * The configuration of the database connection and Hibernate properties is
 * typically done in the application.properties file. However, if you need to
 * provide additional configuration or modify the settings programmatically,
 * you can do so in this class.
 *
 * @author YourName
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:src/main/resources/db/loyaltyhub.db");
        

        return dataSource;
    }
}
