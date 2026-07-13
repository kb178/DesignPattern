package creational.factorymethod;

/**
 * 抽象工厂 - 数据库工厂
 * 定义创建数据库连接的方法，具体由子类决定
 */
public abstract class DatabaseFactory {

    // 工厂方法：创建数据库连接（具体创建什么由子类决定）
    public abstract DatabaseConnection createConnection();

    // 业务方法：使用数据库连接
    public void executeQuery(String sql) {
        System.out.println("=== 开始执行查询 ===");
        DatabaseConnection conn = createConnection();  // 调用工厂方法
        conn.connect();
        conn.query(sql);
        conn.close();
        System.out.println("=== 查询结束 ===");
    }
}
