package creational.singleton;

/**
 * 懒汉式 - 线程不安全版本
 * 用于测试多线程下的问题
 */
public class SingletonUnsafe {

    private static SingletonUnsafe instance;

    private SingletonUnsafe() {
        // 模拟创建耗时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SingletonUnsafe getInstance() {
        if (instance == null) {  // 问题在这里！
            instance = new SingletonUnsafe();
        }
        return instance;
    }
}
