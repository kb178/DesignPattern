package structural.proxy;

/**
 * 抽象主题 - 明星
 * 定义"明星能干什么"的接口，客户端只面向它编程
 */
public interface Star {

    /** 唱歌（演出） */
    void sing(String song);
}
