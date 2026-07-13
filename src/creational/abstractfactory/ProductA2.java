package creational.abstractfactory;

/**
 * 具体产品A2 - 古典椅子
 */
public class ProductA2 implements AbstractProductA {

    @Override
    public void sit() {
        System.out.println("坐在古典雕花椅子上，优雅复古");
    }
}
