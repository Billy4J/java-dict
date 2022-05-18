package com.afterAll.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class User {
    private int id;
    private String name;
    private Time birthday;

    public User() {
    }

    public User(int id, String name, Time birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
