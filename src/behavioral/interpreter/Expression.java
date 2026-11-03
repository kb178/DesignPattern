package behavioral.interpreter;

/**
 * 抽象表达式 - 语法树上的节点
 *
 * interpret()：解释自己这个节点。
 * 叶子（数字/变量）直接给值，枝干（加减乘）先递归解释子树再计算自己。
 */
public interface Expression {

    int interpret(Context context);
}
