package behavioral.command;

/**
 * 接收者 - 厨师
 * 真正干活的人：只认识"做菜/退菜"，
 * 不认识服务员是谁，更不认识顾客是谁（解耦的另一半）
 */
public class Chef {

    public void cook(String dish) {
        System.out.println("  厨师：开始做【" + dish + "】");
    }

    public void cancelCook(String dish) {
        System.out.println("  厨师：【" + dish + "】还没下锅，撤销！");
    }
}
