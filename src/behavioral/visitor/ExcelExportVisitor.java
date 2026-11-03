package behavioral.visitor;

/**
 * 具体访问者 - 导出 Excel
 * "导出Excel"这个操作被完整地收进一个类里，
 * 发票/账单/收据各导出成什么样，一目了然
 */
public class ExcelExportVisitor implements DocVisitor {

    @Override
    public void visit(Invoice invoice) {
        System.out.println("  [Excel] 发票 " + invoice.getNumber()
                + " → 填入行：金额" + invoice.getAmount() + "，税率" + invoice.getTaxRate());
    }

    @Override
    public void visit(Bill bill) {
        System.out.println("  [Excel] 账单 " + bill.getNumber()
                + " → 填入行：客户" + bill.getCustomer() + "，金额" + bill.getAmount());
    }

    @Override
    public void visit(Receipt receipt) {
        System.out.println("  [Excel] 收据 " + receipt.getNumber()
                + " → 填入行：日期" + receipt.getDate() + "，金额" + receipt.getAmount());
    }
}
