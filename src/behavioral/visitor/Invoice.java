package behavioral.visitor;

/**
 * 具体元素 - 发票
 *
 * 注意 accept() 里的写法：visitor.visit(this)。
 * 这里的 this 静态类型就是 Invoice，编译器会绑定到 visit(Invoice) 重载——
 * 双分派的第二步就发生在这行！
 */
public class Invoice implements DocElement {

    private final String number;   // 发票号
    private final double amount;   // 金额
    private final double taxRate;  // 税率（发票特有的字段）

    public Invoice(String number, double amount, double taxRate) {
        this.number = number;
        this.amount = amount;
        this.taxRate = taxRate;
    }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public void accept(DocVisitor visitor) {
        visitor.visit(this);   // 双分派的第二步：绑定到 visit(Invoice)
    }
}
