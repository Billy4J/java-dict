package com.afterAll.mybatis.test;

import com.afterAll.mybatis.entity.User;
import com.afterAll.mybatis.mapper.DynamicSqlMapper;
import com.afterAll.mybatis.mapper.ResultMapper;
import com.afterAll.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    @Test
    public void testMybatis() throws IOException {
        //        获取mybatis的核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //        创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //        通过核心配置文件所对应的字节流创建工厂类SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //        生产SqlSession对象，此时的对象sql必须手动提交或回滚事务
        //        SqlSession sqlSessionNotAuto = sqlSessionFactory.openSession();
        //        其他操作
        //        sqlSessionNotAuto.commit();

        //        开启自动提交创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //        通过代理模式创建爱你UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //        调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行sql语句

        List<User> users = new ArrayList<>();
        users.add(new User(10031, "a", null));
        users.add(new User(10032, "b", null));
        users.add(new User(10030, "c", null));

        System.out.println(sqlSession.getMapper(DynamicSqlMapper.class).deleteUsers(users));
    }
}
