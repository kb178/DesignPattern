package creational.builder;

/**
 * 抽象建造者接口
 * 定义建造房子的步骤
 */
public interface Builder {
    // 打地基
    void buildFoundation();

    // 砌墙
    void buildWall();

    // 盖屋顶
    void buildRoof();

    // 获取建造结果
    House getResult();
}
