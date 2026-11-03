package behavioral.interpreter;

/**
 * 终结符表达式 - 变量
 * 也是叶子，但它的值不是自己定的，要查上下文（a=3 就查出 3）
 */
public class VariableExpression implements Expression {

    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.get(name);   // 查上下文拿变量的值
    }
}
