package behavioral.strategy;

/**
 * 具体策略 - 打折（如双11打8折）
 * 按比例打折
 */
public class PercentageDiscount implements DiscountStrategy {

    private double percentage; // 折扣比例，如 0.8 表示8折

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculate(double originalPrice) {
        double result = originalPrice * percentage;
        System.out.println("【双11】打" + (int)(percentage * 10) + "折：");
        return result;
    }
}
