package behavioral.command;

/**
 * 客户端测试类
 * 演示命令模式的精髓：请求变成对象后，
 * 排队、撤销、记录、组合（套餐）全都顺理成章
 */
public class Client {

    public static void main(String[] args) {
        // 准备：厨师（接收者）和服务员（调用者）
        Chef chef = new Chef();
        Waiter waiter = new Waiter();

        // === 场景1：小明点菜——牛排和汤（请求变成对象）===
        System.out.println("【小明点菜：煎牛排 + 番茄汤】");
        waiter.takeOrder(new SteakCommand(chef));
        waiter.takeOrder(new TomatoSoupCommand(chef));

        System.out.println();

        // === 场景2：下单——请求排队后统一执行 ===
        System.out.println("【下单，厨房开始做】");
        waiter.placeOrder();

        System.out.println();

        // === 场景3：小明反悔，退掉最后一道菜（撤销！）===
        System.out.println("【小明：汤不要了，退掉】");
        waiter.cancelLastDish();

        System.out.println();

        // === 场景4：小红点套餐——多个命令打包成一个 ===
        System.out.println("【小红点套餐：浪漫双人餐】");
        ComboCommand combo = new ComboCommand("浪漫双人餐")
                .addDish(new SteakCommand(chef))
                .addDish(new TomatoSoupCommand(chef));
        waiter.takeOrder(combo);
        waiter.placeOrder();

        System.out.println();

        // === 场景5：小红也反悔了，整个套餐一键撤销 ===
        System.out.println("【小红：整个套餐都不要了】");
        waiter.cancelLastDish();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("把请求封装成对象后：");
        System.out.println("排队（点菜单）、撤销（退菜）、组合（套餐）全都顺理成章。");
        System.out.println("服务员不认识厨师，厨师不认识顾客，靠命令对象解耦。");
        System.out.println("这就是命令模式的精髓。");
    }
}
