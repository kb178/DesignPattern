package creational.factorymethod;

/**
 * 客户端测试类
 * 演示如何使用工厂方法模式
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 使用 MySQL ===");
        // 1. 创建MySQL工厂
        DatabaseFactory mysqlFactory = new MySQLFactory();
        // 2. 执行查询（内部自动创建MySQL连接）
        mysqlFactory.executeQuery("SELECT * FROM users");

        System.out.println();

        System.out.println("=== 使用 Oracle ===");
        // 1. 创建Oracle工厂
        DatabaseFactory oracleFactory = new OracleFactory();
        // 2. 执行查询（内部自动创建Oracle连接）
        oracleFactory.executeQuery("SELECT * FROM orders");
    }
}
