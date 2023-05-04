package ru.chay.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories
public class DBConfig extends AbstractJdbcConfiguration {
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Airline");
        dataSource.setUsername("ilya");
        dataSource.setPassword("123e123e");
        return dataSource;
    }
    @Bean
    NamedParameterJdbcOperations operations(){
        return new NamedParameterJdbcTemplate(dataSource());
    }
    @Bean
    PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
