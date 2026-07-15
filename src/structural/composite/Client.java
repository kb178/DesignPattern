package structural.composite;

/**
 * 客户端测试类
 * 演示组合模式的使用
 */
public class Client {

    public static void main(String[] args) {
        // 创建员工（叶子节点）
        Employee zhangsan = new Employee("张三");
        Employee lisi = new Employee("李四");
        Employee wangwu = new Employee("王五");
        Employee zhaoliu = new Employee("赵六");
        Employee sunqi = new Employee("孙七");

        // 创建小组（容器节点）
        Department devGroup = new Department("开发组");
        devGroup.add(zhangsan);
        devGroup.add(lisi);

        Department testGroup = new Department("测试组");
        testGroup.add(wangwu);

        // 创建部门（容器节点）
        Department techDept = new Department("技术部");
        techDept.add(devGroup);
        techDept.add(testGroup);

        Department marketDept = new Department("市场部");
        marketDept.add(zhaoliu);
        marketDept.add(sunqi);

        // 创建总经理（顶层容器）
        Department ceo = new Department("总经理");
        ceo.add(techDept);
        ceo.add(marketDept);

        // 测试1：显示组织架构
        System.out.println("=== 组织架构 ===");
        ceo.display(0);

        System.out.println();

        // 测试2：统计总人数
        System.out.println("=== 人数统计 ===");
        System.out.println("开发组人数：" + devGroup.getStaffCount());
        System.out.println("技术部人数：" + techDept.getStaffCount());
        System.out.println("公司总人数：" + ceo.getStaffCount());
    }
}
