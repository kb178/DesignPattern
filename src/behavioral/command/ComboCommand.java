package behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 宏命令 - 套餐
 * 把多个命令打包成一个命令：一键执行/撤销一整套
 * （本质是命令模式 + 组合模式的结合）
 */
public class ComboCommand implements OrderCommand {

    private final String comboName;
    private final List<OrderCommand> dishes = new ArrayList<>();

    public ComboCommand(String comboName) {
        this.comboName = comboName;
    }

    /** 添加菜品到套餐 */
    public ComboCommand addDish(OrderCommand dish) {
        dishes.add(dish);
        return this;
    }

    /** 一键执行套餐里的所有菜 */
    @Override
    public void execute() {
        System.out.println("  套餐【" + comboName + "】开始制作：");
        for (OrderCommand dish : dishes) {
            dish.execute();
        }
    }

    /** 一键撤销：倒着撤（后点的先撤，符合直觉） */
    @Override
    public void undo() {
        System.out.println("  套餐【" + comboName + "】整体撤销：");
        for (int i = dishes.size() - 1; i >= 0; i--) {
            dishes.get(i).undo();
        }
    }

    @Override
    public String dishName() {
        return "套餐[" + comboName + "]";
    }
}
