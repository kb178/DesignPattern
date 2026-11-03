package behavioral.interpreter;

/**
 * 非终结符表达式 - 加法
 * 枝干节点：持有左右两棵子树，解释 = 先递归解释两边，再做自己的运算
 */
public class AddExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);   // 递归！
    }
}
