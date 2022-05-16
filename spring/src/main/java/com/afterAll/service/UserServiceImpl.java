package com.afterAll.service;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add...");
    }

    @Override
    public UserService add(int x, int y) {
        System.out.println(x + y);
        return this;
    }
}
