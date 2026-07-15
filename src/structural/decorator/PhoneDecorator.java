package structural.decorator;

/**
 * Decorator（装饰器基类）
 * 
 * 关键点：
 * 1. 实现 Phone 接口（装饰器也是手机）
 * 2. 持有 Phone 引用（可以包裹任何手机）
 */
public abstract class PhoneDecorator implements Phone {

    // 持有被装饰对象的引用
    protected Phone phone;

    public PhoneDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();  // 调用被装饰对象的方法
    }

    @Override
    public void send() {
        phone.send();  // 调用被装饰对象的方法
    }

    @Override
    public String getDescription() {
        return phone.getDescription();  // 调用被装饰对象的方法
    }
}
