package structural.proxy;

/**
 * 客户端测试类
 * 演示代理模式的精髓：粉丝全程只和经纪人打交道，
 * 明星被保护在代理后面，杂事由代理全包
 */
public class Client {

    public static void main(String[] args) {
        // 粉丝找的是"经纪人"（代理），不是明星本人
        Star star = new StarProxy();

        // === 场景1：第一场演出（明星此时还没签约出场！）===
        System.out.println("【场景1：粉丝A找经纪人，办第一场演出】");
        star.sing("《海阔天空》");

        System.out.println();

        // === 场景2：第二场演出（明星已就位，直接演出）===
        System.out.println("【场景2：粉丝B办第二场演出】");
        star.sing("《光辉岁月》");

        System.out.println();
        System.out.println("==========================================");
        System.out.println("粉丝从头到尾只认识经纪人（代理）：");
        System.out.println("验票、宣传、结算都是经纪人做，明星只管唱歌；");
        System.out.println("明星本人直到第一场演出才出场（延迟创建）；");
        System.out.println("换经纪人不影响粉丝，保护了明星。");
        System.out.println("这就是代理模式的精髓。");
    }
}
