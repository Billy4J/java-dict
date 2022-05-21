package com.afterAll.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private int id;
    private String name;
    private Date birthday;

    public User() {
    }

    public User(int id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
