package behavioral.interpreter;

/**
 * 终结符表达式 - 数字
 * 语法树的"叶子"：不再有子节点，解释结果就是它自己
 */
public class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;   // 叶子：直接返回值
    }
}
