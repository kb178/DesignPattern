package behavioral.observer;

/**
 * 客户端测试类
 * 演示观察者模式的精髓：订阅者不用一直盯着，店铺到货自动通知所有人
 */
public class Client {

    public static void main(String[] args) {
        // 1. 有一个店铺，卖手机
        Shop shop = new Shop("小米官方旗舰店");

        // 2. 几个顾客想买小米14，但没货了，先订阅到货通知
        Customer xiaoming = new Customer("小明");
        Customer xiaohong = new Customer("小红");
        Customer xiaogang = new Customer("小刚");

        shop.subscribe(xiaoming);
        shop.subscribe(xiaohong);
        shop.subscribe(xiaogang);

        System.out.println();

        // 3. 等了几天，店铺补货了！
        shop.notifyAll("小米14", "现货充足，快去抢购！");

        System.out.println();
        System.out.println("------------------------------");

        // 4. 小明已经买到了，取消订阅
        shop.unsubscribe(xiaoming);

        System.out.println();

        // 5. 第二批货到，这次小明收不到通知了
        shop.notifyAll("小米14 Pro", "第二批到货，数量有限！");

        System.out.println();
        System.out.println("==========================================");
        System.out.println("店铺只管通知，不关心谁在听；");
        System.out.println("顾客订阅后就等着收通知，不用一直去刷页面。");
        System.out.println("这就是观察者模式的精髓。");
    }
}
