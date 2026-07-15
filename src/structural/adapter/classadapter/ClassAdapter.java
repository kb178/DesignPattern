package structural.adapter.classadapter;

import structural.adapter.Electronic;
import structural.adapter.USLaptop;

/**
 * 类适配器 - 用继承实现
 * 
 * 将美国电器（110V）适配成中国电源接口（220V）
 * 
 * 关键点：Adapter 同时继承 Target 和 Adaptee
 */
public class ClassAdapter extends USLaptop implements Electronic {

    @Override
    public void usePower() {
        System.out.println("类适配器：将220V转换为110V");
        super.usePower();  // 调用父类（美国电器）的方法
    }
}
