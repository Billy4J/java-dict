package com.afterAll.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Value("${mysql8.driverClassName}")
    private String driverClassName;

    @Value("${mysql8.url}")
    private String url;

    @Value("${mysql8.username}")
    private String username;

    @Value("${mysql8.password}")
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
