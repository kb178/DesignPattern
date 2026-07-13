package creational.factorymethod;

/**
 * 具体工厂2 - Oracle工厂
 * 负责创建Oracle数据库连接
 */
public class OracleFactory extends DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        System.out.println("Oracle工厂：创建Oracle连接");
        return new OracleConnection();
    }
}
