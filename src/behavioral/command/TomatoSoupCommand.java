package behavioral.command;

/**
 * 具体命令 - 番茄汤
 */
public class TomatoSoupCommand implements OrderCommand {

    private final Chef chef;

    public TomatoSoupCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cook("番茄汤");
    }

    @Override
    public void undo() {
        chef.cancelCook("番茄汤");
    }

    @Override
    public String dishName() {
        return "番茄汤";
    }
}
