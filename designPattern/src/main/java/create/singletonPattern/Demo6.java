package create.singletonPattern;

public enum Demo6 {
    /**
     * 利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题
     */
    Instance;

    public static void doSomething() {
        // 本身就是单一实例，进行执行
    }
}
