package structural.flyweight;

/**
 * 客户端测试类
 * 演示享元模式的精髓：大量相似对象共享同一份内在状态，
 * "你好你好你好"6个字符只用2个对象
 */
public class Client {

    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();

        // === 场景1：输入"你好你好你好"——6个字符，只建2个对象 ===
        System.out.println("【场景1：输入'你好你好你好'（6个字符）】");
        String text = "你好你好你好";
        for (int i = 0; i < text.length(); i++) {
            String ch = String.valueOf(text.charAt(i));
            Glyph glyph = factory.getGlyph(ch, "宋体");   // 共享！
            glyph.display(i);   // 位置是外在状态，由外部传入
        }
        System.out.println("  → 6个字符共享 " + factory.poolSize() + " 个对象");

        System.out.println();

        // === 场景2：换字体再输入——字体不同是不同的内在状态，再各建一个 ===
        System.out.println("【场景2：用黑体写'你我'（字体不同，算新对象）】");
        Glyph g1 = factory.getGlyph("你", "黑体");
        g1.display(6);
        Glyph g2 = factory.getGlyph("我", "黑体");
        g2.display(7);
        System.out.println("  → 池中共 " + factory.poolSize() + " 个对象");

        System.out.println();
        System.out.println("==========================================");
        System.out.println("字符内容+字体 是内在状态（不变，共享）；");
        System.out.println("显示位置 是外在状态（每次不同，外部传入）；");
        System.out.println("100万个字符可能只需要几十个对象。");
        System.out.println("这就是享元模式的精髓：共享细粒度对象，省内存。");
    }
}
