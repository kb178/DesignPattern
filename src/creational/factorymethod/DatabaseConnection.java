package creational.factorymethod;

/**
 * 抽象产品 - 数据库连接
 * 定义数据库连接的基本功能
 */
public interface DatabaseConnection {
    // 连接数据库
    void connect();

    // 执行查询
    void query(String sql);

    // 关闭连接
    void close();
}
