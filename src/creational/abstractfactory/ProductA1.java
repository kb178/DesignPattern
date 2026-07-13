package creational.abstractfactory;

/**
 * 具体产品A1 - 现代椅子
 */
public class ProductA1 implements AbstractProductA {

    @Override
    public void sit() {
        System.out.println("坐在现代简约椅子上，舒适简洁");
    }
}
