package com.afterAll.spring5newfeat;

import com.afterAll.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean_aop.xml")
public class Junit4Demo {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void test1() {
        userServiceImpl.add();
    }
}


