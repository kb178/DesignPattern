package behavioral.iterator;

import java.util.Iterator;

/**
 * 聚合类 - 书架
 *
 * 内部用数组存书（客户端不知道也不需要知道）。
 * 实现 Iterable 接口后，就能用 for-each 遍历。
 *
 * 如果哪天把内部的数组换成 LinkedList，
 * 客户端的 for-each 代码一行都不用改——这就是迭代器的价值。
 */
public class BookShelf implements Iterable<Book> {

    private final Book[] books;   // 内部结构：数组（对客户端隐藏）
    private int size;

    public BookShelf(int capacity) {
        this.books = new Book[capacity];
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        }
    }

    public int size() {
        return size;
    }

    /** 只给迭代器用的内部访问方法 */
    public Book getBookAt(int index) {
        return books[index];
    }

    /** 正序迭代器（for-each 用的就是它） */
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    /**
     * 倒序遍历：换个迭代器，遍历方式就变了！
     * 返回 Iterable 是为了让它也能写 for-each：for (Book b : shelf.reverse())
     */
    public Iterable<Book> reverse() {
        return () -> new ReverseBookShelfIterator(this);
    }
}
