package structural.bridge;

public class Ylpay implements PayChannel{
    @Override
    public void pay(double amount) {
        System.out.println("银联支付：" + amount + "元");
    }
}
