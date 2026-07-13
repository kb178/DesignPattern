package creational.abstractfactory;

/**
 * 具体产品B2 - 古典桌子
 */
public class ProductB2 implements AbstractProductB {

    @Override
    public void put() {
        System.out.println("在古典实木桌子上放东西，古色古香");
    }
}
