package behavioral.chainofresponsibility;

/**
 * 抽象处理者 - 责任链上的每一环
 *
 * 核心：持有"下家"的引用，自己处理不了就传给下家，
 * 请求沿着链条一直传，直到有人能处理（或传到链尾没人处理）。
 */
public abstract class Handler {

    protected Handler next;      // 下一环（关键！一个引用把处理者串成链条）
    private final String name;   // 处理人是谁

    protected Handler(String name) {
        this.name = name;
    }

    /**
     * 指定下家，返回下家，支持链式组装：
     * teamLeader.setNext(manager).setNext(director);
     */
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    /**
     * 处理请假请求（核心流程，所有子类共用）
     *
     * 能处理   → 自己处理，链条到此为止
     * 处理不了 → 交给下家
     * 没有下家 → 请求走到链尾，无人处理
     */
    public final void handle(LeaveRequest request) {
        if (canApprove(request)) {
            approve(request);
        } else if (next != null) {
            System.out.println("  " + name + "：请假" + request.getDays()
                    + "天超出我的权限，转给上级");
            next.handle(request);   // 关键：顺着链条往下传
        } else {
            // 链尾兜底：整条链都没人能处理
            System.out.println("  " + name + "：我也批不了，上面没有更大的领导了");
            System.out.println("  ❌ " + request.getEmployee() + "请假"
                    + request.getDays() + "天（" + request.getReason() + "）：无人能批，申请驳回");
        }
    }

    /** 子类决定：这个请求我能不能批？ */
    protected abstract boolean canApprove(LeaveRequest request);

    /** 自己处理（审批通过） */
    protected void approve(LeaveRequest request) {
        System.out.println("  " + name + "：请假" + request.getDays()
                + "天在我的权限内，审批通过 ✅");
    }
}
