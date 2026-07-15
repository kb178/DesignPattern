package structural.decorator;

/**
 * ConcreteDecorator - 挂绳
 * 新增功能：便携
 */
public class PhoneStrap extends PhoneDecorator {

    public PhoneStrap(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();  // 先调用原来的功能
        addedBehavior();  // 再加新功能
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + " + 挂绳";
    }

    // 新增行为：便携
    private void addedBehavior() {
        System.out.println("  -> 挂绳：方便携带");
    }
}
