package structural.composite;

/**
 * Leaf（叶子节点）- 员工
 * 没有子节点，是最小的单位
 */
public class Employee implements OrganizationUnit {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display(int depth) {
        // 打印缩进 + 员工名称
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }
        System.out.println(indent + "- " + name);
    }

    @Override
    public int getStaffCount() {
        return 1;  // 员工算1人
    }
}
