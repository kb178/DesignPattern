package behavioral.state;

/**
 * 具体状态 - 待支付
 * 能支付、能取消；没付款不能出餐、不能确认收货
 */
public class PendingState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("  支付成功，等待商家接单");
        order.setState(new CookingState());   // 支付 → 制作中
    }

    @Override
    public void cancel(Order order) {
        System.out.println("  订单取消，未扣款");
        order.setState(new CancelledState()); // 取消 → 已取消
    }

    @Override
    public void deliver(Order order) {
        System.out.println("  还没付款，不能出餐");
    }

    @Override
    public void confirm(Order order) {
        System.out.println("  还没付款，不能确认收货");
    }

    @Override
    public String stateName() {
        return "待支付";
    }
}
