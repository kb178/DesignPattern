package creational.prototype;

/**
 * 具体原型 - 简历
 * 实现克隆方法，可以复制自己
 */
public class Resume implements Cloneable {

    private String name;        // 姓名
    private String education;   // 学历
    private String skills;      // 技能
    private String targetCompany; // 目标公司

    public Resume(String name, String education, String skills) {
        this.name = name;
        this.education = education;
        this.skills = skills;
    }

    public void setTargetCompany(String targetCompany) {
        this.targetCompany = targetCompany;
    }

    // 克隆方法：复制一份简历
    @Override
    public Resume clone() {
        try {
            return (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // 显示简历
    public void show() {
        System.out.println("姓名：" + name);
        System.out.println("学历：" + education);
        System.out.println("技能：" + skills);
        System.out.println("目标公司：" + targetCompany);
    }
}
