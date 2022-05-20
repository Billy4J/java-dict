package com.afterAll.spring5newfeat;

import com.afterAll.entity.User;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 支持函数式风格:() -> new User()
 */
public class GenericApplicationContextDemo {

    @Test
    public void testGenericApplicationContext() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean("user", User.class, () -> new User());
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
