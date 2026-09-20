package behavioral.observer;

/**
 * 具体观察者 - 顾客
 * 每个顾客收到通知后的反应可以不同
 */
public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    /**
     * 收到到货通知后的反应
     * 每个人的反应可以不一样，这就是观察者的灵活性
     */
    @Override
    public void onNotify(String productName, String message) {
        System.out.println("  → 顾客【" + name + "】收到通知：" + productName + " - " + message);
    }
}
