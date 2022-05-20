package com.afterAll.spring5newfeat;

import org.springframework.lang.Nullable;

public class NullAnnotationDemo {
    @Nullable
    private String name;

    public static void test1(@Nullable String name) {

    }

    @Nullable
    public static void test2(String name) {

    }

    public static void main(String[] args) {

    }
}
