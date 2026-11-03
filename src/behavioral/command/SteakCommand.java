package behavioral.command;

/**
 * 具体命令 - 煎牛排
 * 把"请求"（煎牛排）和"接收者"（厨师）绑定在一起
 */
public class SteakCommand implements OrderCommand {

    private final Chef chef;   // 命令知道该找谁干活

    public SteakCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cook("煎牛排");
    }

    @Override
    public void undo() {
        chef.cancelCook("煎牛排");
    }

    @Override
    public String dishName() {
        return "煎牛排";
    }
}
