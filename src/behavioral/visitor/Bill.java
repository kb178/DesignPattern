package behavioral.visitor;

/**
 * 具体元素 - 账单
 */
public class Bill implements DocElement {

    private final String number;    // 账单号
    private final String customer;  // 客户（账单特有的字段）
    private final double amount;    // 金额

    public Bill(String number, String customer, double amount) {
        this.number = number;
        this.customer = customer;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(DocVisitor visitor) {
        visitor.visit(this);   // 绑定到 visit(Bill)
    }
}
