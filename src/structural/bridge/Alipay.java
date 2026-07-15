package structural.bridge;

/**
 * ConcreteImplementorB - 支付宝
 */
public class Alipay implements PayChannel {

    @Override
    public void pay(double amount) {
        System.out.println("支付宝：" + amount + "元");
    }
}
