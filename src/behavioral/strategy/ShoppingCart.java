package behavioral.strategy;

/**
 * 上下文 - 购物车
 * 负责持有商品和折扣策略，结账时使用折扣策略计算价格
 * 它不关心具体是什么折扣，只管调用策略的calculate方法
 */
public class ShoppingCart {

    private String productName;
    private double originalPrice;
    private DiscountStrategy discountStrategy; // 持有折扣策略（关键！）

    public ShoppingCart(String productName, double originalPrice) {
        this.productName = productName;
        this.originalPrice = originalPrice;
    }

    /**
     * 设置折扣策略（运行时可以随时切换！这就是策略模式的精髓）
     * @param strategy 折扣策略
     */
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    /**
     * 结账：调用策略计算最终价格
     */
    public void checkout() {
        System.out.println("------------------------------");
        System.out.println("商品：" + productName + "，原价：" + originalPrice + "元");

        if (discountStrategy == null) {
            System.out.println("未设置折扣策略，默认原价结算");
            System.out.println("应付：" + originalPrice + "元");
            return;
        }

        // 关键：购物车不需要知道具体怎么打折，直接交给策略去做
        double finalPrice = discountStrategy.calculate(originalPrice);
        System.out.println("应付：" + finalPrice + "元");
    }
}
