package structural.facade;

/**
 * 外观 - 家庭影院一键控制
 *
 * 把投影仪、功放、灯光、DVD这一堆子系统的琐碎调用
 * 收拢成两个简单方法：一键观影、一键关闭。
 * 客户端只面对外观，完全不用知道背后有几台设备、按什么顺序开。
 */
public class HomeTheaterFacade {

    private final Projector projector;
    private final Amplifier amplifier;
    private final Lights lights;
    private final DVDPlayer dvd;

    public HomeTheaterFacade() {
        this.projector = new Projector();
        this.amplifier = new Amplifier();
        this.lights = new Lights();
        this.dvd = new DVDPlayer();
    }

    /** 一键观影：背后按正确顺序操控所有设备 */
    public void watchMovie(String movie) {
        System.out.println("  ====== 准备观影 ======");
        lights.dim();             // 1. 灯先暗
        projector.on();           // 2. 投影仪开
        projector.wideScreen();
        amplifier.on();           // 3. 功放开
        amplifier.setVolume(7);
        dvd.on();                 // 4. DVD开
        dvd.play(movie);
    }

    /** 一键关闭：倒着来，安全收场 */
    public void endMovie() {
        System.out.println("  ====== 观影结束 ======");
        dvd.stop();
        dvd.off();
        amplifier.off();
        projector.off();
        lights.bright();
    }
}
