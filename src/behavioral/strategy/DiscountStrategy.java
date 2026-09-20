package behavioral.strategy;

/**
 * 策略接口 - 折扣策略
 * 所有折扣方式都必须实现这个接口
 * 不管怎么打折，都得有"计算折后价"这个能力
 */
public interface DiscountStrategy {

    /**
     * 根据原价计算折后价
     * @param originalPrice 原价
     * @return 折后价
     */
    double calculate(double originalPrice);
}
