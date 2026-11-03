package behavioral.templatemethod;

/**
 * 客户端测试类
 * 演示模板方法模式的精髓：流程骨架只写一遍，每个子类填自己的步骤空
 * 同一个 makeBeverage()，不同的子类跑出完全不同的饮品
 */
public class Client {

    public static void main(String[] args) {
        // === 场景1：做一杯珍珠奶茶（全程默认流程，加料）===
        BeveragePreparer milkTea = new MilkTea();
        milkTea.makeBeverage();

        // === 场景2：做一杯美式咖啡（钩子方法返回false，跳过加料）===
        BeveragePreparer americano = new Coffee(false);
        americano.makeBeverage();

        // === 场景3：做一杯拿铁咖啡（钩子方法返回true，加糖加奶）===
        BeveragePreparer latte = new Coffee(true);
        latte.makeBeverage();

        System.out.println("==========================================");
        System.out.println("三杯饮品，调用的都是同一个 makeBeverage()；");
        System.out.println("骨架（烧水→冲泡→装杯→加料→出杯）只在父类写一遍，");
        System.out.println("子类只填自己那两步，还能用钩子微调流程。");
        System.out.println("这就是模板方法模式的精髓。");
    }
}
