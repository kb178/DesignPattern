package creational.singleton;

/**
 * 懒汉式 - 双重检查锁（Double-Checked Locking）
 * 解决方案2：效率更高，只在第一次加锁
 */
public class SingletonDoubleCheck {

    // volatile 防止指令重排序
    private static volatile SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {          // 第一次检查（不加锁，提高效率）
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {  // 第二次检查（加锁后再次确认）
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
