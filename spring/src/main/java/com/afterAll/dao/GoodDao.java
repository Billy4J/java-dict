package com.afterAll.dao;

import lombok.Data;

@Data
public class GoodDao {
    private int id;
    private String name;

    public GoodDao() {
    }

    public void initMethod() {
        System.out.println("init method");
    }

    public void destroyMethod() {
        System.out.println("destroy method");
    }
}
