package structural.decorator;

/**
 * Component（抽象组件）- 手机接口
 * 定义手机的基本功能
 */
public interface Phone {

    // 打电话
    void call();

    // 发短信
    void send();

    // 获取描述
    String getDescription();
}
