package creational.abstractfactory;

/**
 * 具体工厂1 - 现代家具工厂
 * 生产现代风格的家具
 */
public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractProductA createChair() {
        return new ProductA1();  // 生产现代椅子
    }

    @Override
    public AbstractProductB createTable() {
        return new ProductB1();  // 生产现代桌子
    }
}
