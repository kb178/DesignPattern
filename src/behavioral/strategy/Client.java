package behavioral.strategy;

/**
 * 客户端测试类
 * 演示策略模式的精髓：同一个购物车，切换不同折扣策略，最终价格不同
 */
public class Client {

    public static void main(String[] args) {
        // 小明买了一件衣服，原价200元
        ShoppingCart cart = new ShoppingCart("冬季羽绒服", 200.0);

        // === 场景1：平日购物，没有活动 ===
        cart.setDiscountStrategy(new NoDiscount());
        cart.checkout();
        // 结果：200元，原价

        System.out.println();

        // === 场景2：双11来了，全场打8折 ===
        cart.setDiscountStrategy(new PercentageDiscount(0.8));
        cart.checkout();
        // 结果：160元

        System.out.println();

        // === 场景3：周年庆，满100减20 ===
        cart.setDiscountStrategy(new FixedDiscount(100, 20));
        cart.checkout();
        // 结果：180元

        System.out.println();

        // === 场景4：小明是VIP，会员日打5折 ===
        cart.setDiscountStrategy(new VIPDiscount());
        cart.checkout();
        // 结果：100元

        System.out.println();
        System.out.println("==========================================");
        System.out.println("同样的商品、同样的购物车，");
        System.out.println("只因为换了折扣策略，最终价格完全不同！");
        System.out.println("这就是策略模式的精髓。");
    }
}
