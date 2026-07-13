package creational.builder;

/**
 * 指挥者类（工头）
 * 负责指挥建造流程，不关心具体怎么造
 */
public class Director {

    private Builder builder;

    // 设置建造者
    public Director(Builder builder) {
        this.builder = builder;
    }

    // 指挥建造流程
    public void construct() {
        System.out.println("工头：开始指挥建造...");
        builder.buildFoundation();  // 第一步：打地基
        builder.buildWall();        // 第二步：砌墙
        builder.buildRoof();        // 第三步：盖屋顶
        System.out.println("工头：建造完成！");
    }
}
