package ro.ubb.hellorpc.server.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JDBCConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/Montaniarzii";
    private static final String USER = System.getProperty("username");
    private static final String PASSWORD = System.getProperty("password");


    @Bean
    JdbcOperations jdbcOperations() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    private DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        //        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Montaniarzii");
        dataSource.setInitialSize(2);

        return dataSource;
    }


}
