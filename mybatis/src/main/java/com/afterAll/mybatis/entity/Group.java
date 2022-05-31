package com.afterAll.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private int gid;
    private String gName;
    private String gAddress;
    List<User> users;
}
