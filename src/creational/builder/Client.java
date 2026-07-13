package creational.builder;

/**
 * 客户端测试类
 * 演示如何使用生成器模式
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 建造别墅 ===");
        // 1. 创建别墅施工队
        Builder villaBuilder = new VillaBuilder();
        // 2. 工头指挥别墅施工队
        Director director = new Director(villaBuilder);
        // 3. 开始建造
        director.construct();
        // 4. 获取结果
        House villa = villaBuilder.getResult();
        System.out.println("结果：" + villa);

        System.out.println();

        System.out.println("=== 建造平房 ===");
        // 1. 创建平房施工队
        Builder bungalowBuilder = new BungalowBuilder();
        // 2. 工头指挥平房施工队
        director = new Director(bungalowBuilder);
        // 3. 开始建造
        director.construct();
        // 4. 获取结果
        House bungalow = bungalowBuilder.getResult();
        System.out.println("结果：" + bungalow);
    }
}
