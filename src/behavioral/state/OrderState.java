package behavioral.state;

/**
 * 状态接口 - 订单在某个状态下"能做什么"
 *
 * 核心思想：同一个动作（如"取消"），在不同状态下行为完全不同。
 * 状态模式把"每种状态下的行为"封装成独立的类，
 * 订单（环境类）只管把动作转发给当前状态对象。
 */
public interface OrderState {

    /** 支付 */
    void pay(Order order);

    /** 取消 */
    void cancel(Order order);

    /** 商家出餐、骑手开始配送 */
    void deliver(Order order);

    /** 确认收货 */
    void confirm(Order order);

    /** 状态名（方便打印） */
    String stateName();
}
