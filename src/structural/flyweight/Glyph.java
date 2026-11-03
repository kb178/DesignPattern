package structural.flyweight;

/**
 * 享元 - 字符对象
 *
 * 内在状态（intrinsic）：字符内容和字体——不变的、可以共享的部分
 * 外在状态（extrinsic）：显示位置——每次不同、由外部传入的部分
 *
 * "你好你好你好"6个字其实只需要2个对象：'你'和'好'各一个。
 */
public class Glyph {

    private final String character;   // 内在状态：字符（不可变）
    private final String font;        // 内在状态：字体（不可变）

    public Glyph(String character, String font) {
        this.character = character;
        this.font = font;
    }

    /**
     * 显示字符：位置是外在状态，由调用方传进来，不占用对象自身
     */
    public void display(int position) {
        System.out.println("  字符[" + character + "] 字体" + font + " 显示在位置" + position);
    }
}
