package behavioral.observer;

/**
 * 被观察者接口 - 主题
 * 定义"被订阅"的标准：订阅、取消、通知
 */
public interface Subject {

    // 订阅（关注）
    void subscribe(Observer observer);

    // 取消订阅（取关）
    void unsubscribe(Observer observer);

    // 通知所有订阅者
    void notifyAll(String productName, String message);
}
