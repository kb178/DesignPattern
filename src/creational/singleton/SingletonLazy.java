package creational.singleton;

/**
 * 单例模式 - 懒汉式
 * 特点：用到时才创建实例（懒加载）
 */
public class SingletonLazy {

    // 1. 静态变量，保存唯一实例（初始为null）
    private static SingletonLazy instance;

    // 2. 私有构造函数，防止外部new
    private SingletonLazy() {
        System.out.println("懒汉式：实例被创建");
    }

    // 3. 静态方法，获取唯一实例
    public static SingletonLazy getInstance() {
        if (instance == null) {  // 第一次调用时才创建
            instance = new SingletonLazy();
        }
        return instance;
    }

    // 业务方法
    public void doSomething() {
        System.out.println("懒汉式单例执行业务逻辑");
    }
}
