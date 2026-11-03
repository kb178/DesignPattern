package behavioral.visitor;

/**
 * 抽象访问者 - 对财务文档的"一种操作"
 *
 * 每种元素对应一个 visit 重载：
 *   visit(Invoice) / visit(Bill) / visit(Receipt)
 *
 * 新增一种操作 = 新增一个实现类，元素类一行不改！
 * （反过来，新增一种元素 = 所有访问者都要加方法——见笔记"访问者的代价"）
 */
public interface DocVisitor {

    void visit(Invoice invoice);

    void visit(Bill bill);

    void visit(Receipt receipt);
}
