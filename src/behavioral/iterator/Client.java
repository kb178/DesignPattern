package behavioral.iterator;

import java.util.Iterator;

/**
 * 客户端测试类
 * 演示迭代器模式的精髓：遍历代码统一写法，
 * 不管书架内部是数组还是链表、正序还是倒序，客户端都一样遍历
 */
public class Client {

    public static void main(String[] args) {
        // 1. 造书架，放几本书（书架内部用数组存，客户端不关心）
        BookShelf shelf = new BookShelf(10);
        shelf.addBook(new Book("设计模式", "GoF"));
        shelf.addBook(new Book("重构", "Martin Fowler"));
        shelf.addBook(new Book("代码整洁之道", "Robert C. Martin"));
        shelf.addBook(new Book("人月神话", "Fred Brooks"));

        // === 场景1：手动用迭代器遍历（for-each 的底层就是这个）===
        System.out.println("【场景1：手动迭代器遍历】");
        Iterator<Book> it = shelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println("  读到：" + book.getTitle() + " - " + book.getAuthor());
        }

        System.out.println();

        // === 场景2：for-each 遍历（语法糖，编译器帮你调场景1那套）===
        System.out.println("【场景2：for-each 遍历】");
        for (Book book : shelf) {
            System.out.println("  读到：" + book.getTitle());
        }

        System.out.println();

        // === 场景3：倒序遍历——同一个书架，换个迭代器遍历方式就变 ===
        System.out.println("【场景3：倒序遍历（shelf.reverse()）】");
        for (Book book : shelf.reverse()) {
            System.out.println("  读到：" + book.getTitle());
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("书架内部是数组，但客户端从头到尾不知道；");
        System.out.println("for-each、手动while、倒序，遍历写法全部统一；");
        System.out.println("哪天数组换成链表，客户端一行都不用改。");
        System.out.println("这就是迭代器模式的精髓。");
    }
}
