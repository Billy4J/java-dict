package com.afterAll.dao;


import com.afterAll.entity.Good;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class GoodDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String name;

    public void addGood(Good good) {
        String insertSql = "insert into t_good value(?,?)";
        Object[] args = {good.getId(), good.getName()};
        int res = jdbcTemplate.update(insertSql, args);
        System.out.println(res);
    }

    public void initMethod() {
        System.out.println("init method");
    }

    public void destroyMethod() {
        System.out.println("destroy method");
    }
}
