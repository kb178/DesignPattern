package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者 - 聊天室
 *
 * 协调逻辑全部集中在这里：谁收群发、谁收私聊、消息怎么路由。
 * 用户之间互相不认识，只认识聊天室（中介者）。
 */
public class ChatRoom implements ChatMediator {

    private final String roomName;
    private final List<ChatUser> users = new ArrayList<>();   // 在群成员
    private final List<String> history = new ArrayList<>();   // 聊天记录（中介者还能顺手管这摊事）

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void register(ChatUser user) {
        users.add(user);
        user.setMediator(this);   // 关键：让用户只认识我
        System.out.println("【" + roomName + "】" + user.getName() + " 进群，当前人数：" + users.size());
    }

    @Override
    public void unregister(ChatUser user) {
        users.remove(user);
        System.out.println("【" + roomName + "】" + user.getName() + " 退群，当前人数：" + users.size());
    }

    @Override
    public void broadcast(String message, ChatUser from) {
        history.add(from.getName() + "：" + message);
        // 协调逻辑：群里所有人收到，发送者自己不收
        for (ChatUser user : users) {
            if (user != from) {
                user.receive(message);
            }
        }
    }

    @Override
    public void privateSend(String message, ChatUser from, String toName) {
        history.add("[私聊] " + from.getName() + " → " + toName + "：" + message);
        // 协调逻辑：按名字找人，只发给目标
        for (ChatUser user : users) {
            if (user.getName().equals(toName)) {
                user.receive("(私聊) " + message);
                return;
            }
        }
        System.out.println("【" + roomName + "】找不到叫 " + toName + " 的成员");
    }
}
