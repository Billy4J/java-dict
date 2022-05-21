package com.afterAll.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class Order {
    private int id;
    private String name;
    private Timestamp time;

    public Order() {
    }


    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
