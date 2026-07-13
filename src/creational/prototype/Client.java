package creational.prototype;

/**
 * 客户端测试类
 * 演示如何使用原型模式
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 创建简历模板 ===");
        // 创建一份简历模板（基本信息）
        Resume template = new Resume("张三", "本科", "Java, Python, 设计模式");
        template.setTargetCompany("（待定）");

        System.out.println("模板内容：");
        template.show();

        System.out.println();

        System.out.println("=== 克隆简历投递不同公司 ===");

        // 克隆1：投递阿里巴巴
        Resume resume1 = template.clone();
        resume1.setTargetCompany("阿里巴巴");
        System.out.println("--- 简历1 ---");
        resume1.show();

        System.out.println();

        // 克隆2：投递腾讯
        Resume resume2 = template.clone();
        resume2.setTargetCompany("腾讯");
        System.out.println("--- 简历2 ---");
        resume2.show();

        System.out.println();

        // 克隆3：投递字节跳动
        Resume resume3 = template.clone();
        resume3.setTargetCompany("字节跳动");
        System.out.println("--- 简历3 ---");
        resume3.show();
    }
}
