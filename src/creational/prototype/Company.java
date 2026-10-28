package creational.prototype;

/**
 * 公司类 - 作为简历中的一个属性对象
 */
public class Company implements Cloneable {

    private String name;        // 公司名称
    private String hireDate;    // 入职时间

    public Company(String name, String hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    // 克隆方法
    @Override
    public Company clone() {
        try {
            return (Company) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + "（入职时间：" + hireDate + "）";
    }
}