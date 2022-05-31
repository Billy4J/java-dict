package com.afterAll.mybatis.mapper;

import com.afterAll.mybatis.entity.User;

import java.util.List;

/**
 * 增删改查
 */
public interface UserMapper {

    int addUser();

    int deleteUser();

    int updateUser();

    User getUserById();

    List<User> getAllUser();
}
