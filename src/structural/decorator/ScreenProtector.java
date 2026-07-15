package structural.decorator;

/**
 * ConcreteDecorator - 钢化膜
 * 新增功能：防摔
 */
public class ScreenProtector extends PhoneDecorator {

    public ScreenProtector(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();  // 先调用原来的功能
        addedBehavior();  // 再加新功能
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + " + 钢化膜";
    }

    // 新增行为：防摔
    private void addedBehavior() {
        System.out.println("  -> 钢化膜：屏幕防摔");
    }
}
