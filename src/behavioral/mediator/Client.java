package behavioral.mediator;

/**
 * 客户端测试类
 * 演示中介者模式的精髓：用户之间互相不认识，
 * 所有通信都经过聊天室协调——网状耦合变星型
 */
public class Client {

    public static void main(String[] args) {
        // 1. 建群（中介者）
        ChatRoom room = new ChatRoom("设计模式交流群");

        // 2. 用户进群（注册到中介者）
        ChatUser xiaoming = new ChatUser("小明");
        ChatUser xiaohong = new ChatUser("小红");
        ChatUser xiaogang = new ChatUser("小刚");
        room.register(xiaoming);
        room.register(xiaohong);
        room.register(xiaogang);

        System.out.println();

        // === 场景1：群聊——所有人都收到（发送者自己除外）===
        System.out.println("【场景1：小明群聊】");
        xiaoming.send("大家好，我在学中介者模式！");

        System.out.println();

        // === 场景2：私聊——只有小刚收到（中介者的协调逻辑）===
        System.out.println("【场景2：小红私聊小刚】");
        xiaohong.sendTo("小刚", "晚上一起打游戏？");

        System.out.println();

        // === 场景3：小刚退群后再群聊——小刚收不到了 ===
        System.out.println("【场景3：小刚退群，小明再发言】");
        room.unregister(xiaogang);
        xiaoming.send("小刚走了吗？");

        System.out.println();

        // === 场景4：私聊一个不在群里的人 ===
        System.out.println("【场景4：私聊不在群里的人】");
        xiaoming.sendTo("小李", "在吗？");

        System.out.println();
        System.out.println("==========================================");
        System.out.println("三个用户互相不认识、零引用，");
        System.out.println("群聊/私聊/退群的所有协调逻辑都集中在聊天室。");
        System.out.println("加人减人不影响任何已有用户——网状耦合变成了星型。");
        System.out.println("这就是中介者模式的精髓。");
    }
}
