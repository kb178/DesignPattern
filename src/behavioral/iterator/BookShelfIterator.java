package behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 具体迭代器 - 正序迭代器
 *
 * 把"游标"（当前遍历到哪）藏在迭代器里，
 * 对外只暴露 hasNext() / next() 两个方法——
 * 客户端不需要知道书架内部是数组还是链表。
 */
public class BookShelfIterator implements Iterator<Book> {

    private final BookShelf shelf;
    private int index = 0;   // 游标：当前遍历到第几本

    public BookShelfIterator(BookShelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public boolean hasNext() {
        return index < shelf.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException("书架上没有更多书了");
        }
        Book book = shelf.getBookAt(index);
        index++;
        return book;
    }
}
