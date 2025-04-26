package com.epf.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration

public class DBConfig {

    // Déclaration du Bean DataSource
    @Bean
    public DataSource initDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz"); // URL
        dataSource.setUsername("epf");  // utilisateur
        dataSource.setPassword("mot_de_passe"); // mot de passe
        return dataSource;
    }

    // Déclaration du Bean JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}




