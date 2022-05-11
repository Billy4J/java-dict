package com.afterAll.ioc;

import com.afterAll.dao.FavoritesDao;
import com.afterAll.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBean {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_no_annotation.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        System.out.println(userDao);
        FavoritesDao favorites = context.getBean("favorites", FavoritesDao.class);
        System.out.println(favorites);
    }
}
