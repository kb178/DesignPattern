package behavioral.templatemethod;

/**
 * 具体类 - 珍珠奶茶
 * 只需要实现"冲泡"和"加料"两个变化的步骤，
 * 烧水、装杯、出杯这些固定流程直接复用父类的。
 */
public class MilkTea extends BeveragePreparer {

    public MilkTea() {
        super("珍珠奶茶");
    }

    @Override
    protected void brew() {
        System.out.println("  用85°C热水泡红茶包，泡3分钟");
    }

    @Override
    protected void addCondiments() {
        System.out.println("  加珍珠、加鲜奶");
    }
}
