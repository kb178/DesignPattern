package structural.facade;

/**
 * 子系统 - 灯光
 */
public class Lights {

    public void dim() {
        System.out.println("  灯光调暗");
    }

    public void bright() {
        System.out.println("  灯光调亮");
    }
}
