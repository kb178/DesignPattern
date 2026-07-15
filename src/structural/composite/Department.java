package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite（容器节点）- 部门
 * 有子节点，可以包含员工或其他部门
 */
public class Department implements OrganizationUnit {

    private String name;
    private List<OrganizationUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // 添加子节点（员工或子部门）
    public void add(OrganizationUnit unit) {
        children.add(unit);
    }

    // 删除子节点
    public void remove(OrganizationUnit unit) {
        children.remove(unit);
    }

    // 获取子节点
    public OrganizationUnit getChild(int index) {
        return children.get(index);
    }

    @Override
    public void display(int depth) {
        // 打印缩进 + 部门名称
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        System.out.println(indent + "+ " + name);

        // 遍历所有子节点，递归显示
        for (OrganizationUnit child : children) {
            child.display(depth + 1);  // 递归调用
        }
    }

    @Override
    public int getStaffCount() {
        int count = 0;
        // 遍历所有子节点，累加人数
        for (OrganizationUnit child : children) {
            count += child.getStaffCount();  // 递归调用
        }
        return count;
    }
}
