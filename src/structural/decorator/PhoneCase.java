package structural.decorator;

/**
 * ConcreteDecorator - 手机壳
 * 新增功能：保护手机
 */
public class PhoneCase extends PhoneDecorator {

    public PhoneCase(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();  // 先调用原来的功能
        addedBehavior();  // 再加新功能
    }

    @Override
    public String getDescription() {
        return phone.getDescription() + " + 手机壳";
    }

    // 新增行为：保护手机
    private void addedBehavior() {
        System.out.println("  -> 手机壳：保护手机不被摔坏");
    }
}
