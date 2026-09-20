package behavioral.strategy;

/**
 * 具体策略 - VIP会员专属折扣
 * 会员才能享受的超低折扣
 */
public class VIPDiscount implements DiscountStrategy {

    @Override
    public double calculate(double originalPrice) {
        double result = originalPrice * 0.5;
        System.out.println("【VIP会员日】尊享5折：");
        return result;
    }
}
