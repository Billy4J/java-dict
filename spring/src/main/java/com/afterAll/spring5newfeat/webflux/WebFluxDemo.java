package com.afterAll.spring5newfeat.webflux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WebFluxDemo {
    public static void main(String[] args) {
        //just方法直接声明
        Flux.just(1);
        Flux.just("hello");

        //其他方法声明
        Integer[] arr = {1, 2, 3};
        int[] arr2 = {1, 2, 3};//不能使用这种
        Flux.fromArray(arr);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Flux.fromIterable(integers);

        Stream<Integer> integerStream = integers.stream().filter(integer -> integer > 2);
        Flux.fromStream(integerStream);
    }
}
