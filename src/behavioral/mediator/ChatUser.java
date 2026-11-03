package behavioral.mediator;

/**
 * 同事类 - 聊天用户
 *
 * 只认识中介者（聊天室），不认识其他用户——
 * 发消息丢给中介者，收消息等中介者来调。
 * 用户之间零耦合，加人减人都不影响其他用户。
 */
public class ChatUser {

    private final String name;
    private ChatMediator mediator;   // 只持有中介者！没有任何其他用户的引用

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }

    /** 发群消息：丢给中介者，自己不知道会发给谁 */
    public void send(String message) {
        System.out.println(name + " 发言：" + message);
        mediator.broadcast(message, this);
    }

    /** 发私聊：告诉中介者找谁，中介者负责送达 */
    public void sendTo(String toName, String message) {
        System.out.println(name + " 私聊 " + toName + "：" + message);
        mediator.privateSend(message, this, toName);
    }

    /** 收消息（由中介者调用） */
    public void receive(String message) {
        System.out.println("  → " + name + " 收到：" + message);
    }
}
