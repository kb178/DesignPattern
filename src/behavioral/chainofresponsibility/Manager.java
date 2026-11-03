package behavioral.chainofresponsibility;

/**
 * 具体处理者 - 经理
 * 权限居中：只能批7天以内的假
 */
public class Manager extends Handler {

    private static final int MAX_DAYS = 7; // 审批权限：7天

    public Manager() {
        super("经理");
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }
}
