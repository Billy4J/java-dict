package com.afterAll.spring5newfeat;


import com.afterAll.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean_aop.xml")
//public class Junit5Demo {
//    @Autowired
//    private UserServiceImpl userServiceImpl;
//
//    @Test
//    public void testAdd() {
//        userServiceImpl.add();
//    }
//}


@SpringJUnitConfig(locations = "classpath:bean_with_annotation.xml")
public class Junit5Demo {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testAdd() {
        userServiceImpl.add();
    }
}
