package creational.builder;

/**
 * 产品类 - 房子
 * 最终要建造出来的东西
 */
public class House {
    private String foundation;  // 地基
    private String wall;        // 墙壁
    private String roof;        // 屋顶

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "房子 {" +
                "地基='" + foundation + '\'' +
                ", 墙壁='" + wall + '\'' +
                ", 屋顶='" + roof + '\'' +
                '}';
    }
}
