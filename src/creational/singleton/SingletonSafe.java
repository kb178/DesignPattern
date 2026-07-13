package creational.singleton;

/**
 * 懒汉式 - 线程安全版本（synchronized）
 * 解决方案1：方法加锁
 */
public class SingletonSafe {

    private static SingletonSafe instance;

    private SingletonSafe() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 方法加锁，同一时刻只有一个线程能执行
    public static synchronized SingletonSafe getInstance() {
        if (instance == null) {
            instance = new SingletonSafe();
        }
        return instance;
    }
}
