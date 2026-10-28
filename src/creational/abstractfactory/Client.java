package creational.abstractfactory;

/**
 *
 * AbstractFactory 定义能够生产什么产品的工厂接口
 *
 * AbstractProductA、AbstractProductB 产品接口
 *
 * ProductA1、ProductA2、ProductB1、ProductB2 实现的产品接口的 产品实现
 *
 * ConcreteFactory1、ConcreteFactory2具体工厂，能够去生产一系列产品
 *
 *
 *
 *
 *
 *
 *
 * 客户端测试类
 * 演示如何使用抽象工厂模式
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 现代风格家具 ===");
        // 客户选择现代风格
        AbstractFactory modernFactory = new ConcreteFactory1();
        // 工厂生产配套产品
        AbstractProductA modernChair = modernFactory.createChair();
        AbstractProductB modernTable = modernFactory.createTable();
        // 使用产品
        modernChair.sit();
        modernTable.put();

        System.out.println();

        System.out.println("=== 古典风格家具 ===");
        // 客户选择古典风格
        AbstractFactory classicalFactory = new ConcreteFactory2();
        // 工厂生产配套产品
        AbstractProductA classicalChair = classicalFactory.createChair();
        AbstractProductB classicalTable = classicalFactory.createTable();
        // 使用产品
        classicalChair.sit();
        classicalTable.put();
    }
}
