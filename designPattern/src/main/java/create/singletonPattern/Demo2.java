package create.singletonPattern;

public class Demo2 {
    /**
     * 懒汉模式，线程安全，加锁
     */
    volatile Demo2 demo2;

    public synchronized Demo2 getInstance() {
        if (demo2 == null) {
            demo2 = new Demo2();
        }
        return demo2;
    }
}
