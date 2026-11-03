package behavioral.visitor;

/**
 * 具体访问者 - 导出 PDF
 * 同样的元素，换一个访问者，输出完全不同
 */
public class PdfExportVisitor implements DocVisitor {

    @Override
    public void visit(Invoice invoice) {
        System.out.println("  [PDF] 发票 " + invoice.getNumber()
                + " → 按发票版式生成 PDF（含税率栏）");
    }

    @Override
    public void visit(Bill bill) {
        System.out.println("  [PDF] 账单 " + bill.getNumber()
                + " → 按账单版式生成 PDF（客户：" + bill.getCustomer() + "）");
    }

    @Override
    public void visit(Receipt receipt) {
        System.out.println("  [PDF] 收据 " + receipt.getNumber()
                + " → 按收据版式生成 PDF（" + receipt.getDate() + "）");
    }
}
