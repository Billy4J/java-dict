package create.singletonPattern;

public class Demo1 {
    /**
     * 懒汉模式，线程不安全
     */
    private static Demo1 demo1;

    private Demo1() {
    }

    public Demo1 getInstance() {
        if (demo1 == null) {
            demo1 = new Demo1();
        }
        return demo1;
    }
}
