package behavioral.state;

/**
 * 具体状态 - 已取消（终态）
 * 订单结束，任何操作都不再受理
 */
public class CancelledState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("  订单已取消，不能支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("  订单已取消，不能重复取消");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("  订单已取消，不能出餐");
    }

    @Override
    public void confirm(Order order) {
        System.out.println("  订单已取消，不能确认收货");
    }

    @Override
    public String stateName() {
        return "已取消";
    }
}
