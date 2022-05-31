package com.afterAll.mybatis.mapper;


import com.afterAll.mybatis.entity.Group;
import com.afterAll.mybatis.entity.User;

import java.util.List;

/**
 * 自定义映射resultMap
 */
public interface ResultMapper {

    List<Group> getGroupLikeBySql1Alias(String feat);

    List<Group> getGroupLikeUseResultMap(String feat);

    List<Group> getGroupLikeBySetting(String feat);

    User getUserById(int id);

    User getUserById2(int id);

    User getUserById3(int id);

    Group getGroupUsersById(int gid);

    Group getGroupUsersById2(int gid);

    List<User> getUserByGid(int gid);

}
