package structural.facade;

/**
 * 子系统 - DVD播放器
 */
public class DVDPlayer {

    public void on() {
        System.out.println("  DVD开机");
    }

    public void play(String movie) {
        System.out.println("  DVD开始播放：" + movie);
    }

    public void stop() {
        System.out.println("  DVD停止播放");
    }

    public void off() {
        System.out.println("  DVD关机");
    }
}
