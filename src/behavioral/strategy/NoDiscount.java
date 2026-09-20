package behavioral.strategy;

/**
 * 具体策略 - 无折扣（平日原价）
 * 原价多少就付多少
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double calculate(double originalPrice) {
        System.out.println("【平日】无折扣，原价：");
        return originalPrice;
    }
}
