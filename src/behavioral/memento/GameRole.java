package behavioral.memento;

/**
 * 原发器 - 游戏角色
 *
 * 负责两件事：
 *   1. 存档：把当前状态封装成备忘录对象（快照）
 *   2. 读档：从备忘录恢复状态
 *
 * 关键设计：GameSave（备忘录）是它的静态内部类，
 * 私有字段 + 私有构造器 —— 外部只能"持有"不能"窥探"，
 * 这就是备忘录模式的黑箱实现（封装实现）。
 */
public class GameRole {

    private int hp;        // 血量
    private int mp;        // 蓝量
    private int level;     // 等级
    private String scene;  // 当前场景

    public GameRole(int hp, int mp, int level, String scene) {
        this.hp = hp;
        this.mp = mp;
        this.level = level;
        this.scene = scene;
    }

    /**
     * 存档：把当前状态打包成备忘录
     * 只有 GameRole 知道 GameSave 里存了什么、怎么存
     */
    public GameSave saveState() {
        return new GameSave(hp, mp, level, scene);
    }

    /**
     * 读档：从备忘录恢复状态
     * 只有 GameRole 能读取 GameSave 的内容
     */
    public void restore(GameSave save) {
        this.hp = save.hp;
        this.mp = save.mp;
        this.level = save.level;
        this.scene = save.scene;
    }

    /** 模拟打Boss：状态剧烈变化 */
    public void fightBoss() {
        System.out.println("  与Boss大战三百回合...");
        this.hp = 10;
        this.mp = 5;
        this.scene = "Boss战场（惨败）";
    }

    /** 模拟继续冒险：状态继续变化 */
    public void explore() {
        System.out.println("  继续探索地图...");
        this.level += 5;
        this.hp = 80;
        this.mp = 40;
        this.scene = "暗黑城堡深处";
    }

    /** 展示当前状态 */
    public void show() {
        System.out.println("  角色状态：" + hp + "血 " + mp + "蓝 Lv." + level + " @ " + scene);
    }

    /**
     * 备忘录（存档）—— 黑箱！
     *
     * private 字段 + private 构造器 + 不提供任何 getter：
     *   - 只有 GameRole 能 new 它（读档写档）
     *   - SaveManager 只能"存着它"，完全看不到里面有什么
     *
     * Java 语言机制：外部类可以访问内部类的 private 成员——
     * 这正是黑箱实现赖以成立的关键。
     *
     * 如果做成白箱（public 字段或 public getter），谁都能改存档数据，
     * 封装就破了——想象下存档文件被别人篡改成 99999 血。
     */
    public static class GameSave {
        private final int hp;
        private final int mp;
        private final int level;
        private final String scene;

        private GameSave(int hp, int mp, int level, String scene) {
            this.hp = hp;
            this.mp = mp;
            this.level = level;
            this.scene = scene;
        }
    }
}
