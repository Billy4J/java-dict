package create.singletonPattern;

public class Demo3 {
    /**
     * 懒汉模式，双检锁/双重校验锁（DCL，即 double-checked locking）
     * 通过加锁，可以保证同时只有一个线程走到第二个判空代码中去，这样保证了只创建 一个实例。这里还用到了volatile关键字来修饰singleton，其最关键的作用是防止指令重排。
     */
    private static Demo3 demo3;

    private Demo3() {
    }

    public static Demo3 getInstance() {
        if (demo3 == null) {
            synchronized (Demo3.class) {
                if (demo3 == null) {
                    demo3 = new Demo3();
                }
            }
        }
        return demo3;
    }
}
