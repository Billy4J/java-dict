package com.afterAll.ioc;

import com.afterAll.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "annotationDemo")
public class AnnotationDemo {
    private String name;

    @Autowired
    private UserDao userDao;
}
