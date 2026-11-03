package behavioral.visitor;

/**
 * 具体元素 - 收据
 */
public class Receipt implements DocElement {

    private final String number;   // 收据号
    private final String date;     // 日期（收据特有的字段）
    private final double amount;   // 金额

    public Receipt(String number, String date, double amount) {
        this.number = number;
        this.date = date;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(DocVisitor visitor) {
        visitor.visit(this);   // 绑定到 visit(Receipt)
    }
}
