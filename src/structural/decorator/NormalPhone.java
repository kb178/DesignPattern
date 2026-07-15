package structural.decorator;

/**
 * ConcreteComponent（具体组件）- 普通手机
 * 没有任何装饰的基础手机
 */
public class NormalPhone implements Phone {

    @Override
    public void call() {
        System.out.println("普通手机：打电话");
    }

    @Override
    public void send() {
        System.out.println("普通手机：发短信");
    }

    @Override
    public String getDescription() {
        return "普通手机";
    }
}
