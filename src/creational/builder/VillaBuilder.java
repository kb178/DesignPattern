package creational.builder;

/**
 * 具体建造者1 - 别墅施工队
 * 负责建造别墅
 */
public class VillaBuilder implements Builder {

    private House house = new House();

    @Override
    public void buildFoundation() {
        System.out.println("别墅施工队：打别墅地基（深度5米，钢筋混凝土）");
        house.setFoundation("别墅地基（深度5米，钢筋混凝土）");
    }

    @Override
    public void buildWall() {
        System.out.println("别墅施工队：砌别墅墙壁（三层，落地窗）");
        house.setWall("别墅墙壁（三层，落地窗）");
    }

    @Override
    public void buildRoof() {
        System.out.println("别墅施工队：盖别墅屋顶（坡屋顶，琉璃瓦）");
        house.setRoof("别墅屋顶（坡屋顶，琉璃瓦）");
    }

    @Override
    public House getResult() {
        return house;
    }
}
