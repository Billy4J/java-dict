package com.afterAll.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Favorites {
    private int id;
    private String name;
    private String nullTest;
    private User user;
    private User innerUser;
    private User cascadeInjection;
    private List<Good> goodList;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private String[] arr;
}
