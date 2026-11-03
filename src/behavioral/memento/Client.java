package behavioral.memento;

/**
 * 客户端测试类
 * 演示备忘录模式的精髓：状态变成快照，
 * 随时回到过去，而且管理者只能"存"不能"看"
 */
public class Client {

    public static void main(String[] args) {
        // 准备：游戏角色（原发器）+ 存档管理器（负责人）
        GameRole role = new GameRole(100, 50, 10, "森林入口");
        SaveManager saveManager = new SaveManager();

        // === 场景1：满血出发 ===
        System.out.println("【场景1：满血出发】");
        role.show();

        System.out.println();

        // === 场景2：进Boss前，先存档！ ===
        System.out.println("【场景2：进Boss前，先存档！】");
        saveManager.save("存档位1", role.saveState());

        System.out.println();

        // === 场景3：挑战Boss，惨败 ===
        System.out.println("【场景3：挑战Boss，惨败】");
        role.fightBoss();
        role.show();

        System.out.println();

        // === 场景4：读档！回到战前 ===
        System.out.println("【场景4：读档！回到战前】");
        role.restore(saveManager.load("存档位1"));
        role.show();

        System.out.println();

        // === 场景5：继续冒险变强，再存一个档 ===
        System.out.println("【场景5：继续冒险变强，再存一个档】");
        role.explore();
        role.show();
        saveManager.save("存档位2", role.saveState());

        System.out.println();

        // === 场景6：读存档位1，回到更早的时间点 ===
        System.out.println("【场景6：读存档位1，回到更早的时间点】");
        role.restore(saveManager.load("存档位1"));
        role.show();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("备忘录把'某一时刻的状态'变成了可以保存的对象；");
        System.out.println("存档管理器只负责保管，看不到存档内容（封装）；");
        System.out.println("游戏角色随时能回到过去的任何存档点。");
        System.out.println("这就是备忘录模式的精髓。");
    }
}
