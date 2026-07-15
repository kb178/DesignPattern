package structural.bridge;

/**
 * Abstraction（抽象类）- 支付方式
 * 定义"做什么"（扫码支付、刷脸支付）
 * 持有支付渠道的引用（桥）
 */
public abstract class PayMethod {

    // 桥：连接抽象和实现
    protected PayChannel channel;

    public PayMethod(PayChannel channel) {
        this.channel = channel;
    }

    // 支付（子类实现具体方式）
    public abstract void pay(double amount);
}
