package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者 - 店铺
 * 维护一个订阅者列表，商品到货时自动通知所有订阅者
 */
public class Shop implements Subject {

    private String shopName;
    private List<Observer> subscribers = new ArrayList<>(); // 订阅者列表

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 用户订阅到货通知
     */
    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        System.out.println("【" + shopName + "】新用户订阅成功，当前订阅人数：" + subscribers.size());
    }

    /**
     * 用户取消订阅
     */
    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
        System.out.println("【" + shopName + "】用户取消订阅，当前订阅人数：" + subscribers.size());
    }

    /**
     * 商品到货！通知所有订阅者
     * 关键：店铺不需要知道订阅者是谁，只管遍历通知
     */
    @Override
    public void notifyAll(String productName, String message) {
        System.out.println("【" + shopName + "】" + productName + " 到货了！正在通知所有订阅者...");
        for (Observer observer : subscribers) {
            observer.onNotify(productName, message); // 逐个通知
        }
    }
}
