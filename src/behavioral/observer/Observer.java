package behavioral.observer;

/**
 * 观察者接口 - 订阅者
 * 所有想收到到货通知的人，都必须实现这个接口
 */
public interface Observer {

    /**
     * 收到通知后要做的事
     * @param productName 商品名
     * @param message     通知内容
     */
    void onNotify(String productName, String message);
}
