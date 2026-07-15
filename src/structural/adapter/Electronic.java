package structural.adapter;

/**
 * Electronic（统一接口）
 * 所有电器都实现这个接口
 */
public interface Electronic {
    // 使用电源（不管多少V，统一叫"使用电源"）
    void usePower();
}
