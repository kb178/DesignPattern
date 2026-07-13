package creational.abstractfactory;

/**
 * 具体工厂2 - 古典家具工厂
 * 生产古典风格的家具
 */
public class ConcreteFactory2 implements AbstractFactory {

    @Override
    public AbstractProductA createChair() {
        return new ProductA2();  // 生产古典椅子
    }

    @Override
    public AbstractProductB createTable() {
        return new ProductB2();  // 生产古典桌子
    }
}
