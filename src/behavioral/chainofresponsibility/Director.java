package behavioral.chainofresponsibility;

/**
 * 具体处理者 - 总监
 * 权限最大：能批30天以内的假
 */
public class Director extends Handler {

    private static final int MAX_DAYS = 30; // 审批权限：30天

    public Director() {
        super("总监");
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }
}
