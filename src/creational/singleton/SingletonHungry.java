package creational.singleton;

/**
 * 单例模式 - 饿汉式
 * 特点：类加载时就创建实例（急切加载）
 */
public class SingletonHungry {

    // 1. 静态变量，类加载时就创建实例
    private static SingletonHungry instance = new SingletonHungry();

    // 2. 私有构造函数，防止外部new
    private SingletonHungry() {
        System.out.println("饿汉式：实例被创建");
    }

    // 3. 静态方法，获取唯一实例
    public static SingletonHungry getInstance() {
        return instance;  // 直接返回，不用判断
    }

    // 业务方法
    public void doSomething() {
        System.out.println("饿汉式单例执行业务逻辑");
    }
}
