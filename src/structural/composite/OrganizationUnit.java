package structural.composite;

/**
 * Component（抽象组件）- 组织单元
 * 定义叶子和容器的统一接口
 */
public interface OrganizationUnit {

    // 获取名称
    String getName();

    // 显示信息（打印组织架构）
    void display(int depth);

    // 获取人数
    int getStaffCount();
}
