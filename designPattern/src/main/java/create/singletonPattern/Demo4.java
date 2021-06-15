package create.singletonPattern;

public class Demo4 {
    /**
     * 饿汉模式,线程安全
     */
    private static Demo4 demo4 = new Demo4();

    private Demo4() {
    }

    public static Demo4 getInstance() {
        return demo4;
    }
}
