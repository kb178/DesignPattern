package behavioral.interpreter;

/**
 * 客户端测试类
 * 演示解释器模式的精髓：把"语言规则"写成一棵语法树，
 * 建树一次，换组变量反复解释
 */
public class Client {

    public static void main(String[] args) {
        // === 场景1：手动搭语法树：(3 + 5) - 2 ===
        System.out.println("【场景1：手动搭语法树，解释 (3 + 5) - 2】");
        //        [-]
        //       /   \
        //     [+]    2
        //    /   \
        //   3     5
        Expression tree1 = new SubExpression(
                new AddExpression(new NumberExpression(3), new NumberExpression(5)),
                new NumberExpression(2));
        System.out.println("  语法树：((3 + 5) - 2)");
        System.out.println("  解释结果：" + tree1.interpret(new Context()));

        System.out.println();

        // === 场景2：解析器解析带变量的算式：a + b * 2（乘法优先）===
        System.out.println("【场景2：解析 a + b * 2，a=3, b=5】");
        Expression tree2 = new Calculator("a + b * 2").parse();
        Context ctx = new Context();
        ctx.set("a", 3);
        ctx.set("b", 5);
        System.out.println("  语法树：(a + (b * 2))");
        System.out.println("  解释结果：" + tree2.interpret(ctx));   // 3 + 5*2 = 13

        System.out.println();

        // === 场景3：同一棵树，换一组变量值，换个结果（建树一次，反复解释）===
        System.out.println("【场景3：同一棵树换变量值：a=10, b=1】");
        Context ctx2 = new Context();
        ctx2.set("a", 10);
        ctx2.set("b", 1);
        System.out.println("  解释结果：" + tree2.interpret(ctx2));  // 10 + 1*2 = 12

        System.out.println();
        System.out.println("==========================================");
        System.out.println("把'算式'变成了一棵可以反复解释的语法树：");
        System.out.println("终结符是叶子（数字/变量），非终结符是枝干（加减乘）；");
        System.out.println("解释 = 从树根递归走到叶子求值。");
        System.out.println("这就是解释器模式的精髓：规则写成树，解释就是递归求值。");
    }
}
