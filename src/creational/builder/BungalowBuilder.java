package creational.builder;

/**
 * 具体建造者2 - 平房施工队
 * 负责建造平房
 */
public class BungalowBuilder implements Builder {

    private House house = new House();

    @Override
    public void buildFoundation() {
        System.out.println("平房施工队：打平房地基（深度2米，普通混凝土）");
        house.setFoundation("平房地基（深度2米，普通混凝土）");
    }

    @Override
    public void buildWall() {
        System.out.println("平房施工队：砌平房墙壁（一层，普通窗户）");
        house.setWall("平房墙壁（一层，普通窗户）");
    }

    @Override
    public void buildRoof() {
        System.out.println("平房施工队：盖平房屋顶（平顶，防水层）");
        house.setRoof("平房屋顶（平顶，防水层）");
    }

    @Override
    public House getResult() {
        return house;
    }
}
