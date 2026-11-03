package behavioral.chainofresponsibility;

/**
 * 请假请求 - 在链条上传递的请求对象
 * 它只管描述"谁请假、请几天、为什么"，
 * 不关心最终是谁审批的（解耦！）
 */
public class LeaveRequest {

    private final String employee; // 申请人
    private final int days;        // 请假天数
    private final String reason;   // 请假原因

    public LeaveRequest(String employee, int days, String reason) {
        this.employee = employee;
        this.days = days;
        this.reason = reason;
    }

    public String getEmployee() {
        return employee;
    }

    public int getDays() {
        return days;
    }

    public String getReason() {
        return reason;
    }
}
