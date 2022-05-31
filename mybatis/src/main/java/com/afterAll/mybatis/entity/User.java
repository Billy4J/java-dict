package com.afterAll.mybatis.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private int id;
    private String name;
    private Date birthday;
    private Group group;

    public User() {
    }

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public User(int id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
