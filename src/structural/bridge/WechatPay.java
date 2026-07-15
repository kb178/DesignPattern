package structural.bridge;

/**
 * ConcreteImplementorA - 微信支付
 */
public class WechatPay implements PayChannel {

    @Override
    public void pay(double amount) {
        System.out.println("微信支付：" + amount + "元");
    }
}
