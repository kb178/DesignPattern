package structural.bridge;

/**
 * RefinedAbstraction - 扫码支付
 */
public class ScanPay extends PayMethod {

    public ScanPay(PayChannel channel) {
        super(channel);
    }

    @Override
    public void pay(double amount) {
        System.out.println("【扫码支付】");
        System.out.print("  -> ");
        channel.pay(amount);  // 调用支付渠道的实现
    }
}
