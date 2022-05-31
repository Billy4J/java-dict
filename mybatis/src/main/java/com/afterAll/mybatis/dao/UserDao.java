package com.afterAll.mybatis.dao;

import com.afterAll.mybatis.entity.User;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql = "insert into t_user value(?,?,?)";
        Object[] arg = {user.getId(), user.getName(), user.getBirthday()};
        int res = jdbcTemplate.update(sql, arg);
        System.out.println(res);
    }

}
