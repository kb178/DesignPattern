package behavioral.state;

/**
 * 具体状态 - 已完成（终态）
 * 订单结束，任何操作都不再受理
 */
public class CompletedState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("  订单已完成，不能支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("  订单已完成，不能取消");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("  订单已完成，不能出餐");
    }

    @Override
    public void confirm(Order order) {
        System.out.println("  订单已完成，不能重复确认");
    }

    @Override
    public String stateName() {
        return "已完成";
    }
}
