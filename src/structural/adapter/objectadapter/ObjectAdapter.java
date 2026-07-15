package structural.adapter.objectadapter;

import structural.adapter.Electronic;
import structural.adapter.USLaptop;

/**
 * 对象适配器 - 用组合实现
 * 
 * 将美国电器（110V）适配成中国电源接口（220V）
 * 
 * 关键点：Adapter 持有 Adaptee 的引用
 * 更灵活，运行时可以换不同的 Adaptee
 */
public class ObjectAdapter implements Electronic {

    // 持有被适配者的引用（用接口类型，更灵活）
    private Electronic adaptee;

    public ObjectAdapter(Electronic adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void usePower() {
        System.out.println("对象适配器：将220V转换为110V");
        adaptee.usePower();  // 调用引用对象的方法
    }
}
