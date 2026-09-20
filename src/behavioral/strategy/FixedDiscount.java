package behavioral.strategy;

/**
 * 具体策略 - 满减（如周年庆满100减20）
 * 满足条件就减固定金额
 */
public class FixedDiscount implements DiscountStrategy {

    private double threshold; // 满多少
    private double reduction; // 减多少

    public FixedDiscount(double threshold, double reduction) {
        this.threshold = threshold;
        this.reduction = reduction;
    }

    @Override
    public double calculate(double originalPrice) {
        if (originalPrice >= threshold) {
            double result = originalPrice - reduction;
            System.out.println("【周年庆】满" + (int) threshold + "减" + (int) reduction + "：");
            return result;
        }
        System.out.println("【周年庆】未满" + (int) threshold + "，不享受满减：");
        return originalPrice;
    }
}
