package structural.facade;

/**
 * 客户端测试类
 * 演示外观模式的精髓：一键观影，背后十几个步骤由外观包办，
 * 客户端不用知道有几台设备、按什么顺序开
 */
public class Client {

    public static void main(String[] args) {
        // 客户端只认识外观（遥控器），不认识背后的设备
        HomeTheaterFacade theater = new HomeTheaterFacade();

        // === 场景1：一键观影 ===
        System.out.println("【场景1：小明按下'观影'按钮】");
        theater.watchMovie("盗梦空间");

        System.out.println();

        // === 场景2：一键关闭 ===
        System.out.println("【场景2：电影看完了，按下'关闭'按钮】");
        theater.endMovie();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("小明只按了两个按钮（watchMovie / endMovie）；");
        System.out.println("背后4台设备、十几个步骤，顺序全对，小明毫不知情；");
        System.out.println("明天换新设备？只改外观类，客户端一行不动。");
        System.out.println("这就是外观模式的精髓：简单入口，隐藏细节。");
    }
}
