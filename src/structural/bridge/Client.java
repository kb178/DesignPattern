package structural.bridge;

/**
 * 客户端测试类
 * 演示桥接模式的使用
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 扫码支付 + 微信 ===");
        PayMethod scanWechat = new ScanPay(new WechatPay());
        scanWechat.pay(100.0);

        System.out.println();

        System.out.println("=== 扫码支付 + 支付宝 ===");
        PayMethod scanAli = new ScanPay(new Alipay());
        scanAli.pay(200.0);

        System.out.println();

        System.out.println("=== 扫码支付 + 银联 ===");
        PayMethod scanYl = new ScanPay(new Ylpay());
        scanAli.pay(200.0);

        System.out.println();

        System.out.println("=== 刷脸支付 + 微信 ===");
        PayMethod faceWechat = new FacePay(new WechatPay());
        faceWechat.pay(150.0);

        System.out.println();

        System.out.println("=== 刷脸支付 + 支付宝 ===");
        PayMethod faceAli = new FacePay(new Alipay());
        faceAli.pay(300.0);

        System.out.println();

        System.out.println("=== 刷脸支付 + 银联 ===");
        PayMethod faceYl = new FacePay(new Ylpay());
        faceAli.pay(300.0);
    }
}
