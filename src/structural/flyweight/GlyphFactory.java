package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂 - 字符池
 * 同样的字符只创建一个对象，之后都复用它
 * （"你"出现一万次，内存里也只有一个"你"对象）
 */
public class GlyphFactory {

    private final Map<String, Glyph> pool = new HashMap<>();   // 享元池

    /**
     * 获取字符对象：池里有就复用，没有才新建
     * @param character 字符
     * @param font      字体（内在状态的一部分）
     */
    public Glyph getGlyph(String character, String font) {
        String key = character + "-" + font;
        if (!pool.containsKey(key)) {
            pool.put(key, new Glyph(character, font));
            System.out.println("  [字符池] 新建字符对象：" + key);
        }
        return pool.get(key);   // 永远返回同一个对象
    }

    /** 看看池里到底存了几个对象 */
    public int poolSize() {
        return pool.size();
    }
}
