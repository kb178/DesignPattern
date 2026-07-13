package creational.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * 多线程测试 - 验证懒汉式线程不安全
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 测试懒汉式线程不安全 ===");
        System.out.println("启动10个线程，同时获取单例...\n");

        // 存储所有获取到的实例地址
        Set<Integer> instanceHashes = new HashSet<>();

        // 启动10个线程
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                SingletonSafe singleton = SingletonSafe.getInstance();
                int hash = singleton.hashCode();
                System.out.println("线程 " + Thread.currentThread().getName() 
                    + " 获取到实例，hashCode=" + hash);
                instanceHashes.add(hash);
            });
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n=== 结果分析 ===");
        System.out.println("总共创建了 " + instanceHashes.size() + " 个不同的实例");
        if (instanceHashes.size() > 1) {
            System.out.println("❌ 线程不安全！创建了多个实例！");
        } else {
            System.out.println("✅ 线程安全，只有1个实例");
        }
    }
}
