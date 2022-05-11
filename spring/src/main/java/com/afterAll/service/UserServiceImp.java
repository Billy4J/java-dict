package com.afterAll.service;

import com.afterAll.ioc.AnnotationDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp {

    @Autowired
    private AnnotationDemo annotationDemo;

}
