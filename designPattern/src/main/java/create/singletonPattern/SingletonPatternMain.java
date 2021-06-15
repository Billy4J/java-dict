package create.singletonPattern;

/**
 * 一共有五种实现方式
 * 懒汉模式：
 * 饿汉模式：
 */

public class SingletonPatternMain {

    public static void main(String[] args) {
        boolean flag = Demo6.Instance == Demo6.Instance;
        System.out.println(flag);
    }
}

















