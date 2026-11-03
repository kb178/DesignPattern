package structural.facade;

/**
 * 子系统 - 功放
 */
public class Amplifier {

    public void on() {
        System.out.println("  功放开机");
    }

    public void setVolume(int level) {
        System.out.println("  功放音量调到 " + level);
    }

    public void off() {
        System.out.println("  功放关机");
    }
}
