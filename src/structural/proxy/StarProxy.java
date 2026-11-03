package structural.proxy;

/**
 * 代理 - 经纪人（替身）
 *
 * 和明星实现同一个接口，粉丝以为在和明星打交道，其实全程是经纪人在处理：
 *   1. 保护代理：验票、控场（控制对真实对象的访问）
 *   2. 虚拟代理：需要时才真正签约明星（延迟创建大对象）
 *   3. 杂事全包：演出前后的准备和收尾
 */
public class StarProxy implements Star {

    private RealStar realStar;   // 持有真实对象（先不创建，延迟加载）

    @Override
    public void sing(String song) {
        // 演出前：代理做杂事
        System.out.println("  【经纪人】验票、宣传、安排彩排");

        // 虚拟代理：第一次演出才真正创建明星对象
        if (realStar == null) {
            realStar = new RealStar();
        }

        // 核心工作：转交给真实对象
        realStar.sing(song);

        // 演出后：代理继续做杂事
        System.out.println("  【经纪人】结算出场费、安排下一场");
    }
}
