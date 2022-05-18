package com.afterAll.dao;

import com.afterAll.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add() {
        System.out.println("方法执行...");
    }

    public void addUser(User user) {
        String insertSql = "insert into t_user value(?,?,?)";
        Object[] args = {user.getId(), user.getName(),user.getBirthday()};
        int res = jdbcTemplate.update(insertSql, args);
        System.out.println(res);
    }
}
