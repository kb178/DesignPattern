package behavioral.iterator;

/**
 * 元素 - 书
 * 就是被遍历的普通对象
 */
public class Book {

    private final String title;   // 书名
    private final String author;  // 作者

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
