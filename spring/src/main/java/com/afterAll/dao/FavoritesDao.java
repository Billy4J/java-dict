package com.afterAll.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Data
public class FavoritesDao {
    private int id;
    private String name;
    private String nullTest;
    private UserDao userDao;
    private UserDao innerUserDao;
    private UserDao cascadeInjection;
    private List<GoodDao> goodDaoList;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private String[] arr;

}
