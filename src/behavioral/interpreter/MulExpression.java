package behavioral.interpreter;

/**
 * 非终结符表达式 - 乘法
 */
public class MulExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public MulExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
