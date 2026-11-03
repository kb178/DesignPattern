package behavioral.chainofresponsibility;

/**
 * 客户端测试类
 * 演示责任链模式的精髓：请求只管往链条上一丢，
 * 谁来处理、处理到哪一站，客户端完全不关心
 */
public class Client {

    public static void main(String[] args) {
        // 1. 组装审批链：组长 → 经理 → 总监
        TeamLeader teamLeader = new TeamLeader();
        Manager manager = new Manager();
        Director director = new Director();
        teamLeader.setNext(manager).setNext(director);   // 链式组装，像真正的汇报线

        System.out.println("审批链组装完成：组长 → 经理 → 总监");
        System.out.println();

        // === 场景1：小明请1天假，组长就能批 ===
        System.out.println("【小明请假1天：感冒了想休息】");
        teamLeader.handle(new LeaveRequest("小明", 1, "感冒"));

        System.out.println();

        // === 场景2：小红请5天假，组长批不了，流转到经理 ===
        System.out.println("【小红请假5天：家里有事】");
        teamLeader.handle(new LeaveRequest("小红", 5, "家里有事"));

        System.out.println();

        // === 场景3：小刚请15天假，一路流转到总监 ===
        System.out.println("【小刚请假15天：结婚度蜜月】");
        teamLeader.handle(new LeaveRequest("小刚", 15, "结婚"));

        System.out.println();

        // === 场景4：老王请40天假，整条链都没人能批 ===
        System.out.println("【老王请假40天：环球旅行】");
        teamLeader.handle(new LeaveRequest("老王", 40, "环球旅行"));

        System.out.println();
        System.out.println("==========================================");
        System.out.println("请求只管丢给链条的第一个处理者，");
        System.out.println("谁能处理谁就处理，处理不了就往下传，");
        System.out.println("客户端不知道（也不需要知道）最终是谁批的。");
        System.out.println("这就是责任链模式的精髓。");
    }
}
