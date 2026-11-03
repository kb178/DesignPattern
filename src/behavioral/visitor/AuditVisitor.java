package behavioral.visitor;

/**
 * 具体访问者 - 审计统计
 *
 * 重点演示：这个类是"后来才加的新操作"，
 * 而 Invoice / Bill / Receipt 三个元素类一行都没改！
 * 访问者模式让"加操作"变得极其容易。
 */
public class AuditVisitor implements DocVisitor {

    private double totalAmount = 0;   // 访问者还能携带遍历过程中的统计状态

    @Override
    public void visit(Invoice invoice) {
        System.out.println("  [审计] 发票 " + invoice.getNumber() + "：金额 " + invoice.getAmount());
        totalAmount += invoice.getAmount();
    }

    @Override
    public void visit(Bill bill) {
        System.out.println("  [审计] 账单 " + bill.getNumber() + "：金额 " + bill.getAmount());
        totalAmount += bill.getAmount();
    }

    @Override
    public void visit(Receipt receipt) {
        System.out.println("  [审计] 收据 " + receipt.getNumber() + "：金额 " + receipt.getAmount());
        totalAmount += receipt.getAmount();
    }

    /** 汇总审计结果 */
    public void report() {
        System.out.println("  [审计] 总金额合计：" + totalAmount);
    }
}
