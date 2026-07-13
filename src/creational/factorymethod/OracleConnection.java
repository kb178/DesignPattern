package creational.factorymethod;

/**
 * 具体产品2 - Oracle数据库连接
 */
public class OracleConnection implements DatabaseConnection {

    @Override
    public void connect() {
        System.out.println("连接 Oracle 数据库：jdbc:oracle:thin:@localhost:1521:orcl");
    }

    @Override
    public void query(String sql) {
        System.out.println("Oracle 执行查询：" + sql);
    }

    @Override
    public void close() {
        System.out.println("关闭 Oracle 连接");
    }
}
