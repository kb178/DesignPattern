package creational.factorymethod;

/**
 * 具体产品1 - MySQL数据库连接
 */
public class MySQLConnection implements DatabaseConnection {

    @Override
    public void connect() {
        System.out.println("连接 MySQL 数据库：jdbc:mysql://localhost:3306/mydb");
    }

    @Override
    public void query(String sql) {
        System.out.println("MySQL 执行查询：" + sql);
    }

    @Override
    public void close() {
        System.out.println("关闭 MySQL 连接");
    }
}
