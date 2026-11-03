package behavioral.state;

/**
 * 具体状态 - 配送中
 * 骑手已在路上：只能确认收货，不能取消（骑手白跑了！）
 */
public class DeliveringState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("  已支付过了，不能重复支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("  骑手已在路上，不能取消！");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("  已经在配送中了");
    }

    @Override
    public void confirm(Order order) {
        System.out.println("  确认收货，订单完成！");
        order.setState(new CompletedState()); // 确认 → 已完成
    }

    @Override
    public String stateName() {
        return "配送中";
    }
}
