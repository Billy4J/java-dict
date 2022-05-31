package com.afterAll.mybatis.mapper;

import com.afterAll.mybatis.entity.User;

import java.util.List;

public interface DynamicSqlMapper {

    List<User> getUser(User user);

    List<User> getUser2(User user);

    List<User> getUser3(User user);

    List<User> getUser4(User user);

    int insertUsers(List<User> users);

    int deleteUsers(List<User> users);

    int deleteUsers2(List<User> users);
}
