package behavioral.state;

/**
 * 环境类 - 订单
 *
 * 持有"当前状态"，把动作转发给状态对象处理。
 * 订单自己不知道每个状态下有什么规则，规则全在状态类里——
 * 换规则、加状态，订单类一行都不用改。
 */
public class Order {

    private final String orderId;
    private OrderState state = new PendingState();   // 初始状态：待支付

    public Order(String orderId) {
        this.orderId = orderId;
    }

    // ===== 把动作原样转发给当前状态处理 =====

    public void pay() {
        System.out.println("【" + orderId + "】执行操作：支付");
        state.pay(this);
    }

    public void cancel() {
        System.out.println("【" + orderId + "】执行操作：取消");
        state.cancel(this);
    }

    public void deliver() {
        System.out.println("【" + orderId + "】执行操作：出餐配送");
        state.deliver(this);
    }

    public void confirm() {
        System.out.println("【" + orderId + "】执行操作：确认收货");
        state.confirm(this);
    }

    /**
     * 状态流转：由状态对象在合适时机调用
     * （比如 PendingState.pay() 里会调 order.setState(new CookingState())）
     */
    public void setState(OrderState state) {
        this.state = state;
        System.out.println("  ---- 订单状态变为【" + state.stateName() + "】----");
    }

    public void show() {
        System.out.println("订单" + orderId + " 当前状态：" + state.stateName());
    }
}
