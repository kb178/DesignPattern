package structural.decorator;

/**
 * 客户端测试类
 * 演示装饰器模式的使用
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 场景1：裸机（没有装饰）===");
        Phone phone = new NormalPhone();
        System.out.println("配置：" + phone.getDescription());
        phone.call();

        System.out.println();

        System.out.println("=== 场景2：加手机壳 ===");
        Phone phoneWithCase = new PhoneCase(new NormalPhone());
        System.out.println("配置：" + phoneWithCase.getDescription());
        phoneWithCase.call();

        System.out.println();

        System.out.println("=== 场景3：手机壳 + 钢化膜（嵌套装饰）===");
        Phone phoneWithCaseAndFilm = new PhoneCase(new ScreenProtector(new NormalPhone()));
        System.out.println("配置：" + phoneWithCaseAndFilm.getDescription());
        phoneWithCaseAndFilm.call();

        System.out.println();

        System.out.println("=== 场景4：手机壳 + 钢化膜 + 挂绳（三层嵌套）===");
        Phone fullPhone = new PhoneCase(new ScreenProtector(new PhoneStrap(new NormalPhone())));
        System.out.println("配置：" + fullPhone.getDescription());
        fullPhone.call();
    }
}
