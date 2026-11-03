package behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文 - 变量环境
 * 存放表达式里变量的名字和取值（比如 a=3, b=5），
 * 终结符（变量）解释时来查它。
 */
public class Context {

    private final Map<String, Integer> variables = new HashMap<>();

    public void set(String name, int value) {
        variables.put(name, value);
    }

    public int get(String name) {
        return variables.get(name);
    }
}
