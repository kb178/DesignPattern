package creational.abstractfactory;

/**
 * 抽象工厂接口
 * 定义工厂能生产什么产品
 */
public interface AbstractFactory {
    // 生产椅子
    AbstractProductA createChair();

    // 生产桌子
    AbstractProductB createTable();
}
