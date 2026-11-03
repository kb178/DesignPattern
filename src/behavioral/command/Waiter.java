package behavioral.command;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 调用者 - 服务员
 * 只认识命令对象，不认识厨师（关键！）
 * 负责攒单、下单、退菜——请求变成对象后，这些全都能做了
 */
public class Waiter {

    private final List<OrderCommand> orderSheet = new ArrayList<>();   // 点菜单（排队）
    private final Deque<OrderCommand> servedHistory = new ArrayDeque<>(); // 已上菜记录（用于撤销）

    /** 顾客点菜：先记在单子上（请求排队！） */
    public void takeOrder(OrderCommand dish) {
        orderSheet.add(dish);
        System.out.println("服务员：记下【" + dish.dishName() + "】");
    }

    /** 下单给厨房：整张单子一次性执行 */
    public void placeOrder() {
        System.out.println("服务员：下单到厨房！");
        for (OrderCommand dish : orderSheet) {
            dish.execute();
            servedHistory.push(dish);   // 记录，方便之后撤销
        }
        orderSheet.clear();
    }

    /** 退掉最后一道菜：撤销最近执行的命令 */
    public void cancelLastDish() {
        if (servedHistory.isEmpty()) {
            System.out.println("服务员：没有可退的菜了");
            return;
        }
        OrderCommand last = servedHistory.pop();
        System.out.println("服务员：退掉最后一道【" + last.dishName() + "】");
        last.undo();
    }
}
