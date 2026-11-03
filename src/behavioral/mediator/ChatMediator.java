package behavioral.mediator;

/**
 * 中介者接口 - 聊天室
 *
 * 核心思想：用户之间不再直接联系，所有消息都经过中介者转发。
 * 多对多的网状耦合，变成一对多的星型结构。
 */
public interface ChatMediator {

    /** 用户进群（把自己注册到中介者） */
    void register(ChatUser user);

    /** 用户退群 */
    void unregister(ChatUser user);

    /** 群发：所有人可见（除了发送者自己） */
    void broadcast(String message, ChatUser from);

    /** 私聊：只有目标用户可见 */
    void privateSend(String message, ChatUser from, String toName);
}
