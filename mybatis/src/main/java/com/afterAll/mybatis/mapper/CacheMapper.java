package com.afterAll.mybatis.mapper;

import com.afterAll.mybatis.entity.User;


/**
 * 一级缓存生效情况：在同一个session中默认自动生效
 *
 * <p>
 * 二级缓存生效条件：
 * 1.mybatis-config.xml配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
 * 2.在mapper.xml中，设置标签<cache />
 * 3.二级缓存必须在SqlSession关闭或提交之后有效
 * 4.查询的数据所转换的实体类类型必须实现序列化的接口
 *
 * <p>
 * 一级缓存失效的四种情况：
 * 1.使用不同的sqlSession
 * 2.使用不同的查询条件
 * 3.两次查询中执行增删改操作
 * 4.清空sqlSession
 *
 * <p>
 * 二级缓存失效的情况：
 * 在两次查询中执行增删改操作
 */
public interface CacheMapper {

    User getUserById(int id);
}
