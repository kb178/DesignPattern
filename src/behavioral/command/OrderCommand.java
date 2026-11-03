package behavioral.command;

/**
 * 命令接口 - 菜单上的一道菜
 *
 * 把"点菜请求"封装成对象：请求不再是一次性的方法调用，
 * 而是能拿在手里、传来传去、攒起来、退回去的"单子"。
 * 这就是命令模式的精髓：**请求即对象**。
 *
 * 注：标准 GoF 接口只有 execute()，这里加 undo()（撤销）和
 * dishName()（方便打印），是为了演示命令对象的完整能力。
 */
public interface OrderCommand {

    /** 下单执行：通知厨房做菜 */
    void execute();

    /** 退菜撤销：反着来一遍 */
    void undo();

    /** 这道菜叫什么（方便服务员打印） */
    String dishName();
}
