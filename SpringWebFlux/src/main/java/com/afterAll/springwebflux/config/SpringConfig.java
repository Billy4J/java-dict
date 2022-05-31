package com.afterAll.springwebflux.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfig {

    @Value("${prop.driverClass}")
    private String driverClassName;

    @Value("${prop.url}")
    private String url;

    @Value("${prop.username}")
    private String username;

    @Value("${prop.password}")
    private String password;

    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
