package structural.proxy;

/**
 * 真实主题 - 明星本人
 * 真正干活的人，不想被杂事打扰（所以藏在代理后面）
 */
public class RealStar implements Star {

    public RealStar() {
        System.out.println("  【真实明星】签约出场（真实对象被创建）");
    }

    @Override
    public void sing(String song) {
        System.out.println("  【真实明星】倾情演唱：" + song);
    }
}
