package com.afterall.springwebflux.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class User {
    private int id;
    private String name;
    private Time birthday;
}
