package com.afterAll.mybatis.mapper;

import com.afterAll.mybatis.entity.User;

import java.util.List;

/**
 * 特殊sql执行
 */
public interface SqlMapper {

    List<User> getUsersByFuzzy(String fuzzy);

    /**
     * 使用sql中的 in (x,y) 语法，只能使用${}方式字符串拼接
     *
     * @param ids
     * @return
     */
    int deleteMore(String ids);

    /**
     * 动态设置表名，查询所有的用户信息,只能使用${}
     *
     * @param tableName
     * @return
     */
    List<User> getAllUser(String tableName);

    /**
     * 添加用户信息
     *
     * @param user
     * @return useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
     * 数user对象的某个属性中
     */
    int insertUser(User user);

}
