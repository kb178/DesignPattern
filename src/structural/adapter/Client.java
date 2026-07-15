package structural.adapter;

import structural.adapter.classadapter.ClassAdapter;
import structural.adapter.objectadapter.ObjectAdapter;

/**
 * 客户端测试类
 * 演示适配器模式的使用
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== 场景1：中国电器直接使用（不需要适配）===");
        Electronic chinaLaptop = new ChinaLaptop();
        chinaLaptop.usePower();

        System.out.println();

        System.out.println("=== 场景2：美国电器直接使用（接口不兼容）===");
        Electronic usLaptop = new USLaptop();
        usLaptop.usePower();  // 虽然能调用，但实际是110V

        System.out.println();

        System.out.println("=== 场景3：用类适配器适配美国电器 ===");
        Electronic classAdapter = new ClassAdapter();
        classAdapter.usePower();

        System.out.println();

        System.out.println("=== 场景4：用对象适配器适配美国电器 ===");
        Electronic objectAdapter = new ObjectAdapter(new USLaptop());
        objectAdapter.usePower();

        System.out.println();

        System.out.println("=== 场景5：对象适配器可以适配多种电器 ===");
        // 适配器可以适配任何 Electronic 实现类
        Electronic adapter1 = new ObjectAdapter(new USLaptop());
        Electronic adapter2 = new ObjectAdapter(new ChinaLaptop());  // 甚至可以适配中国电器
        adapter1.usePower();
        adapter2.usePower();
    }
}
