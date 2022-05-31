package com.afterAll.mybatisGenerator.test;

import com.afterAll.mybatisGenerator.bean.User;
import com.afterAll.mybatisGenerator.bean.UserExample;
import com.afterAll.mybatisGenerator.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestDemo {
    @Test
    public void test1() {
        UserExample userExample = new UserExample();
        userExample.createCriteria();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Page<Object> objects = PageHelper.startPage(2, 3);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdGreaterThan(0);
        List<User> users = mapper.selectByExample(userExample);
//        System.out.println(objects);

        PageInfo<User> userPageInfo = new PageInfo<>(users,5);
        System.out.println(userPageInfo);

    }
}
