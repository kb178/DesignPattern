package behavioral.chainofresponsibility;

/**
 * 具体处理者 - 组长
 * 权限最小：只能批3天以内的假
 */
public class TeamLeader extends Handler {

    private static final int MAX_DAYS = 3; // 审批权限：3天

    public TeamLeader() {
        super("组长");
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }
}
