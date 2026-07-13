package creational.abstractfactory;

/**
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
