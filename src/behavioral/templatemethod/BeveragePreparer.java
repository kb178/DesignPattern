package behavioral.templatemethod;

/**
 * 抽象类 - 饮品制作（模板类）
 *
 * 定义制作饮品的算法骨架：烧水 → 冲泡 → 装杯 → 加料 → 封口出杯
 * 其中"冲泡"和"加料"每种饮品不同，交给子类实现；
 * 其他步骤完全一样，写一遍到处复用，子类不用再管。
 */
public abstract class BeveragePreparer {

    private final String beverageName;

    protected BeveragePreparer(String beverageName) {
        this.beverageName = beverageName;
    }

    /**
     * 模板方法 - 定义算法骨架（制作流程）
     *
     * 用 final 修饰：子类只能重写某些步骤，不能改变整个流程的顺序！
     * 这就是"模板"的含义——骨架已经定死，只留几个空让子类填。
     */
    public final void makeBeverage() {
        System.out.println("开始制作【" + beverageName + "】：");
        boilWater();                     // 固定步骤：直接复用
        brew();                          // 变化步骤：子类实现（抽象方法）
        pourInCup();                     // 固定步骤：直接复用
        if (customerWantsCondiments()) { // 钩子方法：子类可以影响流程！
            addCondiments();             // 变化步骤：子类实现（抽象方法）
        }
        sealAndServe();                  // 固定步骤：直接复用
        System.out.println("✅ 一杯" + beverageName + "制作完成！");
        System.out.println();
    }

    // ========== 固定步骤：所有饮品都一样，写一遍到处复用 ==========

    /** 烧开水 */
    private void boilWater() {
        System.out.println("  烧开水（100°C）");
    }

    /** 倒入杯中 */
    private void pourInCup() {
        System.out.println("  倒入杯中");
    }

    /** 封口出杯 */
    private void sealAndServe() {
        System.out.println("  封口出杯");
    }

    // ========== 变化步骤：每种饮品不同，子类必须实现 ==========

    /** 冲泡：奶茶泡茶包、咖啡萃取咖啡液……子类必须实现 */
    protected abstract void brew();

    /** 加料：加珍珠还是加柠檬……子类必须实现 */
    protected abstract void addCondiments();

    // ========== 钩子方法：子类可选覆盖 ==========

    /**
     * 钩子方法（Hook）：顾客要不要加料？
     *
     * 默认要加料。子类可以覆盖它来影响流程——
     * 比如美式咖啡顾客说"今天不加糖奶"，就返回 false，跳过加料步骤。
     *
     * 钩子方法 vs 抽象方法：
     *   抽象方法：子类"必须"实现（没有它做不出饮品）
     *   钩子方法：子类"可以"覆盖（有默认行为，不覆盖也照样跑）
     */
    protected boolean customerWantsCondiments() {
        return true;
    }
}
