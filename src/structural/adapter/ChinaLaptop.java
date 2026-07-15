package structural.adapter;

/**
 * 中国电器 - 中国笔记本电脑
 * 直接使用220V电源（不需要适配）
 */
public class ChinaLaptop implements Electronic {

    @Override
    public void usePower() {
        System.out.println("中国笔记本：使用220V电源，正常工作");
    }
}
