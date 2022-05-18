package com.afterAll.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Order {
    private int id;
    private String name;
    private Time time;

    public Order() {
    }


    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
