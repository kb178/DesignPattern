package creational.singleton;

/**
 * 客户端测试类
 * 演示单例模式的使用
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 测试懒汉式 ===");
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();

        System.out.println("s1 == s2 ? " + (s1 == s2));  // true
        s1.doSomething();

        System.out.println();

        System.out.println("=== 测试饿汉式 ===");
        SingletonHungry s3 = SingletonHungry.getInstance();
        SingletonHungry s4 = SingletonHungry.getInstance();

        System.out.println("s3 == s4 ? " + (s3 == s4));  // true
        s3.doSomething();
    }
}
