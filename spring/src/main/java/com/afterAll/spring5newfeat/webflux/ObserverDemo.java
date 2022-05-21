package com.afterAll.spring5newfeat.webflux;

import java.util.Observable;

public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver((o, arg) -> {
            System.out.println("手动发生变化");
        });
        observerDemo.addObserver((o, arg) -> System.out.println("第二个变化:" + arg));
        observerDemo.setChanged();
        observerDemo.notifyObservers("520");
    }
}
