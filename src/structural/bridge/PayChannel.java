package structural.bridge;

/**
 * Implementor（实现接口）- 支付渠道
 * 定义"怎么做"（具体支付实现）
 */
public interface PayChannel {
    // 支付
    void pay(double amount);
}
