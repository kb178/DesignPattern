package structural.facade;

/**
 * 子系统 - 投影仪
 * 真正干活的设备之一，接口琐碎（开机、宽屏、关机……）
 */
public class Projector {

    public void on() {
        System.out.println("  投影仪开机");
    }

    public void wideScreen() {
        System.out.println("  投影仪切换宽屏模式");
    }

    public void off() {
        System.out.println("  投影仪关机");
    }
}
