package com.afterAll.ioc;

import com.afterAll.entity.Favorites;
import com.afterAll.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBean {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_no_annotation.xml");
        User user = context.getBean("userDao", User.class);
        System.out.println(user);
        Favorites favorites = context.getBean("favorites", Favorites.class);
        System.out.println(favorites);
    }
}
