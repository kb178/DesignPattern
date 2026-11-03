package behavioral.templatemethod;

/**
 * 具体类 - 咖啡
 * 除了实现两个抽象步骤，还演示了"钩子方法"：
 * 顾客可以决定要不要加料（美式不加，拿铁加）
 */
public class Coffee extends BeveragePreparer {

    private final boolean withCondiments; // 顾客要不要加料

    public Coffee(boolean withCondiments) {
        super(withCondiments ? "拿铁咖啡" : "美式咖啡");
        this.withCondiments = withCondiments;
    }

    @Override
    protected void brew() {
        System.out.println("  研磨咖啡豆，高压萃取咖啡液");
    }

    @Override
    protected void addCondiments() {
        System.out.println("  加糖、加牛奶");
    }

    /**
     * 覆盖钩子方法：根据顾客需求决定要不要加料
     * 返回 false 时，模板方法会跳过 addCondiments()，流程就变了
     */
    @Override
    protected boolean customerWantsCondiments() {
        return withCondiments;
    }
}
