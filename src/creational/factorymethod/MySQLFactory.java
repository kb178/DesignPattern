package creational.factorymethod;

/**
 * 具体工厂1 - MySQL工厂
 * 负责创建MySQL数据库连接
 */
public class MySQLFactory extends DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        System.out.println("MySQL工厂：创建MySQL连接");
        return new MySQLConnection();
    }
}
