package behavioral.interpreter;

/**
 * 解析器 - 把算式字符串解析成语法树（客户端的"翻译官"）
 *
 * 文法规则（递归下降，乘除优先于加减就体现在文法层级里）：
 *   表达式  expr   := 项 (('+'|'-') 项)*
 *   项      term   := 因子 ('*' 因子)*
 *   因子    factor := 数字 | 变量
 *
 * 输入算式用空格分隔，如 "a + b * 2"。
 */
public class Calculator {

    private final String[] tokens;
    private int pos = 0;

    public Calculator(String input) {
        this.tokens = input.split(" ");
    }

    /** 解析入口：算式 → 语法树 */
    public Expression parse() {
        return expr();
    }

    // expr := term (('+'|'-') term)*
    private Expression expr() {
        Expression left = term();
        while (pos < tokens.length && (tokens[pos].equals("+") || tokens[pos].equals("-"))) {
            String op = tokens[pos++];
            Expression right = term();
            left = op.equals("+")
                    ? new AddExpression(left, right)
                    : new SubExpression(left, right);
        }
        return left;
    }

    // term := factor ('*' factor)*
    private Expression term() {
        Expression left = factor();
        while (pos < tokens.length && tokens[pos].equals("*")) {
            pos++;
            Expression right = factor();
            left = new MulExpression(left, right);
        }
        return left;
    }

    // factor := 数字 | 变量
    private Expression factor() {
        String token = tokens[pos++];
        if (Character.isDigit(token.charAt(0))) {
            return new NumberExpression(Integer.parseInt(token));
        }
        return new VariableExpression(token);
    }
}
