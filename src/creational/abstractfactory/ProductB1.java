package creational.abstractfactory;

/**
 * 具体产品B1 - 现代桌子
 */
public class ProductB1 implements AbstractProductB {

    @Override
    public void put() {
        System.out.println("在现代简约桌子上放东西，干净利落");
    }
}
