package behavioral.visitor;

/**
 * 抽象元素 - 财务文档
 *
 * accept(访问者)：让访问者"上门访问"我。
 * 元素类只需要这一个方法，具体操作全在访问者那边。
 */
public interface DocElement {

    void accept(DocVisitor visitor);
}
