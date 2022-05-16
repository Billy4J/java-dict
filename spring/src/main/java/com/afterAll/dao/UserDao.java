package com.afterAll.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userDao")
@Data
public class UserDao {
    @Value(value = "1")
    private int id;
    private String name;

    public void add() {
        System.out.println("方法执行...");
    }
}
