package behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 具体迭代器 - 倒序迭代器
 *
 * 同一个书架，换一个迭代器，遍历方式就完全不同——
 * 遍历策略被独立出来了，这正是迭代器模式的精髓之一。
 */
public class ReverseBookShelfIterator implements Iterator<Book> {

    private final BookShelf shelf;
    private int index;   // 游标：从最后一本开始

    public ReverseBookShelfIterator(BookShelf shelf) {
        this.shelf = shelf;
        this.index = shelf.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException("书架上没有更多书了");
        }
        Book book = shelf.getBookAt(index);
        index--;
        return book;
    }
}
