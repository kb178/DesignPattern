package structural.bridge;

/**
 * RefinedAbstraction - 刷脸支付
 */
public class FacePay extends PayMethod {

    public FacePay(PayChannel channel) {
        super(channel);
    }

    @Override
    public void pay(double amount) {
        System.out.println("【刷脸支付】");
        System.out.print("  -> ");
        channel.pay(amount);  // 调用支付渠道的实现
    }
}
