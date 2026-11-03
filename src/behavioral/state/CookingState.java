package behavioral.state;

/**
 * 具体状态 - 制作中
 * 商家已接单在做菜：能出餐配送、能取消（要退款）；不能重复支付
 */
public class CookingState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("  已支付过了，不能重复支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("  订单取消，已支付金额原路退回");
        order.setState(new CancelledState());
    }

    @Override
    public void deliver(Order order) {
        System.out.println("  骑手已取餐，开始配送");
        order.setState(new DeliveringState()); // 出餐 → 配送中
    }

    @Override
    public void confirm(Order order) {
        System.out.println("  菜还没做好，不能确认收货");
    }

    @Override
    public String stateName() {
        return "制作中";
    }
}
