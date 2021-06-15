package create.singletonPattern;

public class Demo5 {
    /**
     * 懒汉模式，登记式/静态内部类，线程安全
     * 可能还存在反射攻击或者反序列化攻击。
     */
    private Demo5() {
    }

    private static class Instance {
        public static final Demo5 INSTANCE = new Demo5();
    }

    public static final Demo5 getInstance() {
        return Instance.INSTANCE;
    }
}
