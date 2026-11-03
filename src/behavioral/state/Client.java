package behavioral.state;

/**
 * 客户端测试类
 * 演示状态模式的精髓：同一个"取消"操作，
 * 订单处于不同状态时行为完全不同，而且不用写一堆 if-else
 */
public class Client {

    public static void main(String[] args) {
        // === 场景1：刚下单就反悔（待支付 → 取消）===
        System.out.println("【场景1：小明刚下单就反悔】");
        Order order1 = new Order("1001");
        order1.cancel();

        System.out.println();

        // === 场景2：付完钱又不想要了（制作中 → 取消，要退款）===
        System.out.println("【场景2：小红付完钱又不想要了】");
        Order order2 = new Order("1002");
        order2.pay();          // 待支付 → 制作中
        order2.cancel();       // 制作中 → 已取消（退款！）

        System.out.println();

        // === 场景3：骑手在路上想取消（配送中 → 取消被拒！）===
        System.out.println("【场景3：小刚想在配送中取消】");
        Order order3 = new Order("1003");
        order3.pay();          // 待支付 → 制作中
        order3.deliver();      // 制作中 → 配送中
        order3.cancel();       // 配送中：不受理！

        System.out.println();

        // === 场景4：正常流程走到完成 ===
        System.out.println("【场景4：小丽的订单正常走完全流程】");
        Order order4 = new Order("1004");
        order4.pay();          // 待支付 → 制作中
        order4.deliver();      // 制作中 → 配送中
        order4.confirm();      // 配送中 → 已完成

        System.out.println();

        // === 场景5：已完成的订单，什么都做不了（终态）===
        System.out.println("【场景5：小丽想对已完成的订单再操作】");
        order4.cancel();
        order4.pay();
        order4.show();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("四张订单，调用的都是同一个 cancel()，");
        System.out.println("但结果各不相同——取决于订单当前处于什么状态。");
        System.out.println("每个状态知道'我能做什么、做不了什么、下一步到哪'，");
        System.out.println("订单类只负责转发，全程没有一个 if-else。");
        System.out.println("这就是状态模式的精髓。");
    }
}
