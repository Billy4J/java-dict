package com.afterAll.springwebflux.dao;

import com.afterAll.springwebflux.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
@Data
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql = "insert into t_user value(?,?,?)";
        Object[] arg = {user.getId(), user.getName(), user.getBirthday()};
        int res = jdbcTemplate.update(sql, arg);
        System.out.println(res);
    }

    public void batchAddUser(List<User> users) {
        String sql = "insert into t_user values(?,?,?)";
        List<Object[]> argList = new ArrayList<>();
        for (User user : users) {
            Object[] arg = {user.getId(), user.getName(), user.getBirthday()};
            argList.add(arg);
        }
        int[] res = jdbcTemplate.batchUpdate(sql, argList);
        System.out.println(Arrays.toString(res));
    }

    public User findUser(int id) {
        String sql = "select * from t_user where id=?";
        Object[] arg = {id};
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), arg);
        return user;
    }

    public List<User> findAllUser() {
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
}
