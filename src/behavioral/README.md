# 行为型模式（Behavioral Patterns）

> 行为型模式关注的是**对象之间的职责分配与通信**：不是怎么创建对象（创建型），也不是怎么组合对象（结构型），而是**对象之间怎么协作、怎么把变化的行为抽出来**。

## 学习进度

| # | 模式 | 状态 | 示例场景 | 包 |
|---|------|------|----------|-----|
| 1 | 策略模式（Strategy） | ✅ 已完成 | 购物车折扣 | `strategy/` |
| 2 | 观察者模式（Observer） | ✅ 已完成 | 商品到货通知 | `observer/` |
| 3 | 模板方法（Template Method） | ⬜ 待学 | — | — |
| 4 | 责任链模式（Chain of Responsibility） | ⬜ 待学 | — | — |
| 5 | 命令模式（Command） | ⬜ 待学 | — | — |
| 6 | 状态模式（State） | ⬜ 待学 | — | — |
| 7 | 中介者模式（Mediator） | ⬜ 待学 | — | — |
| 8 | 备忘录模式（Memento） | ⬜ 待学 | — | — |
| 9 | 迭代器模式（Iterator） | ⬜ 待学 | — | — |
| 10 | 访问者模式（Visitor） | ⬜ 待学 | — | — |
| 11 | 解释器模式（Interpreter） | ⬜ 待学 | — | — |

## 如何运行

IDEA 中直接运行各包下的 `Client.main()`，或命令行：

```bash
javac -encoding UTF-8 -d out/check src/behavioral/strategy/*.java
java -cp out/check behavioral.strategy.Client

javac -encoding UTF-8 -d out/check src/behavioral/observer/*.java
java -cp out/check behavioral.observer.Client
```

---

# 一、策略模式（Strategy Pattern）

## 什么是策略模式？

**一句话**：定义一系列算法，把它们一个个封装起来，并且使它们可以互相替换。

**大白话**：把"怎么做"这件事抽成接口，主体只管调用，不管具体怎么做。**同一件事，换一种做法，主体代码一行不改。**

## 生活中的例子：去机场

同样是"从家到机场"这件事：

| 策略 | 做法 | 特点 |
|------|------|------|
| 🚗 打车 | 直接叫车 | 贵但省事 |
| 🚇 地铁 | 换乘两次 | 便宜但挤 |
| 🚌 机场大巴 | 到点发车 | 便宜但慢 |
| 🚁 直升机 | 有钱任性 | 贵但最快 |

"出行"这个需求不变，**换的是实现方式**。选哪个是运行时决定的（看时间、看预算），而不是出门前写死的。

## 角色对照

| GoF 角色 | 本例类 | 职责 |
|----------|--------|------|
| Context（上下文） | `ShoppingCart` | 持有商品，调用策略算价格 |
| Strategy（抽象策略） | `DiscountStrategy` | 定义"计算折后价"的接口 |
| ConcreteStrategy（具体策略） | `NoDiscount` / `PercentageDiscount` / `FixedDiscount` / `VIPDiscount` | 各种打折方式 |
| Client（客户端） | `Client` | 决定用哪个策略 |

## 类图

```
┌──────────────────────┐         ┌─────────────────────────┐
│     ShoppingCart     │         │ «interface»             │
│──────────────────────│ 持有    │    DiscountStrategy     │
│ - productName        │────────▶│─────────────────────────│
│ - originalPrice      │         │ + calculate(originalPrice)│
│ - discountStrategy   │         └───────────┬─────────────┘
│──────────────────────│                     │ 实现（实现同一个接口）
│ + setDiscountStrategy│     ┌───────────────┼────────────────┬──────────┐
│ + checkout()         │     ▼               ▼                ▼          ▼
└──────────────────────┘ ┌──────────┐ ┌──────────────┐ ┌──────────┐ ┌──────────┐
                         │NoDiscount│ │Percentage    │ │ Fixed    │ │   VIP    │
                         │          │ │Discount      │ │ Discount │ │ Discount │
                         └──────────┘ └──────────────┘ └──────────┘ └──────────┘
```

**关键**：`ShoppingCart` 只依赖抽象的 `DiscountStrategy`，不依赖任何一个具体折扣类。

## 核心思想

### 先看不用策略模式的写法（反面教材）

```java
public class ShoppingCart {
    public void checkout(int discountType) {   // 1=打折 2=满减 3=VIP ...
        double finalPrice;
        if (discountType == 1) {
            finalPrice = originalPrice * 0.8;
        } else if (discountType == 2) {
            finalPrice = originalPrice >= 100 ? originalPrice - 20 : originalPrice;
        } else if (discountType == 3) {
            // ... 再来20行
        }
        // 新增一种折扣？改这个方法，全量回归测试，违反开闭原则！
    }
}
```

**问题**：
1. `checkout()` 又要管流程又要管所有算法，越加越臃肿
2. 新增折扣 = 修改已有代码，违反**开闭原则**（对扩展开放，对修改关闭）
3. 打折算法和购物车耦合，算法没法复用（比如订单系统也想用）

### 用了策略模式之后

```java
// 新增一种折扣？新增一个类，已有代码一行不改
public class SecondHalfDiscount implements DiscountStrategy {
    @Override
    public double calculate(double originalPrice) {
        return originalPrice / 2;
    }
}

cart.setDiscountStrategy(new SecondHalfDiscount());  // 直接换上，购物车无感知
```

**变化点被封装在独立的类里，主体只面向接口编程。**

## 代码讲解

**策略接口**——所有折扣的"能力契约"：

```java
public interface DiscountStrategy {
    double calculate(double originalPrice);   // 不管怎么打折，都得会算折后价
}
```

**上下文**——持有策略而不是写死策略：

```java
public class ShoppingCart {
    private DiscountStrategy discountStrategy;   // 关键：持有的是接口

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;        // 运行时随时切换！
    }

    public void checkout() {
        // 购物车不需要知道具体怎么打折，直接交给策略去做
        double finalPrice = discountStrategy.calculate(originalPrice);
        System.out.println("应付：" + finalPrice + "元");
    }
}
```

**四个具体策略**：`NoDiscount`（原价）、`PercentageDiscount`（打折，如 0.8=8折）、`FixedDiscount`（满100减20）、`VIPDiscount`（会员5折）。每个类只关心自己那一种算法。

## 运行结果

```
------------------------------
商品：冬季羽绒服，原价：200.0元
【平日】无折扣，原价：
应付：200.0元

------------------------------
商品：冬季羽绒服，原价：200.0元
【双11】打8折：
应付：160.0元

------------------------------
商品：冬季羽绒服，原价：200.0元
【周年庆】满100减20：
应付：180.0元

------------------------------
商品：冬季羽绒服，原价：200.0元
【VIP会员日】尊享5折：
应付：100.0元

==========================================
同样的商品、同样的购物车，
只因为换了折扣策略，最终价格完全不同！
这就是策略模式的精髓。
```

## 适用场景

- **同一个问题有多种可互换的算法**（排序、加密、压缩、计价、路由）
- **需要在运行时动态切换**算法，而不是编译时写死
- **一堆 if-else / switch 选择不同算**法，且算法会不断新增
- 想**避免暴露算法内部数据**给客户端（策略自己管自己的参数，比如 `FixedDiscount` 自带 threshold/reduction）

## 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 消灭 if-else，符合开闭原则 | ❌ 类数量增多（一个算法一个类） |
| ✅ 算法可复用、可独立测试 | ❌ 客户端必须知道策略之间的区别才能选 |
| ✅ 运行时自由切换 | ❌ 策略间如果有共享数据会传参变多 |
| ✅ 组合代替继承，符合"多用组合少用继承" | |

## 进阶讨论点（讲课/面试可用）

1. **`double` 算钱的坑**：浮点精度问题，实际项目用 `BigDecimal`。本例为了演示简洁用了 `double`。
2. **策略里混了 `System.out.println`**：`calculate()` 既算价又打印，职责不纯。生产上策略只负责算，展示交给上下文——演示里混着写是为了输出更直观。
3. **`PercentageDiscount` 的显示截断**：`(int)(percentage * 10)` 传 0.85 会显示"8折"而非"8.5折"，注意业务展示的精度。
4. **策略 vs 模板方法**：两者都是"封装变化的算法"。策略用**组合+接口**，运行时切换；模板方法用**继承+钩子**，编译时定骨架。对比着学效果最好。
5. **策略 vs 工厂**：工厂管"造出哪个对象"，策略管"对象怎么干活"。两者经常一起用——用工厂决定造哪个策略，用策略去执行。

---

# 二、观察者模式（Observer Pattern）

## 什么是观察者模式？

**一句话**：定义对象间的一种一对多依赖，当一个对象状态改变时，所有依赖它的对象都会自动收到通知并更新。

**大白话**：**订阅通知**。你关注了店铺，店铺一到货就自动告诉你，不用你天天去刷页面。

## 生活中的例子：关注店铺到货提醒

- **没关注**：想买小米14，每天刷一遍店铺页面 → 累，还可能错过
- **关注了**：点一下"到货提醒"，该干嘛干嘛，货到了手机自动弹通知

对店铺来说也一样：不用挨个发短信告诉顾客（点名耦合），只要对"所有订阅者"吼一嗓子。

## 角色对照

| GoF 角色 | 本例类 | 职责 |
|----------|--------|------|
| Subject（抽象被观察者/主题） | `Subject` | 定义订阅、退订、通知的接口 |
| ConcreteSubject（具体主题） | `Shop` | 维护订阅者列表，到货时通知 |
| Observer（抽象观察者） | `Observer` | 定义"收到通知怎么办"的接口 |
| ConcreteObserver（具体观察者） | `Customer` | 各自的收到通知后的反应 |
| Client（客户端） | `Client` | 订阅/退订/触发通知 |

## 类图

```
┌───────────────────────────┐          ┌───────────────────────────┐
│ «interface»               │          │ «interface»               │
│        Subject            │          │        Observer           │
│───────────────────────────│          │───────────────────────────│
│ + subscribe(observer)     │          │ + onNotify(productName,   │
│ + unsubscribe(observer)   │          │           message)        │
│ + notifyAll(name, msg)    │          └─────────────┬─────────────┘
└────────────┬──────────────┘                        │ 实现
             │ 实现                                  ▼
     ┌───────┴────────┐                    ┌───────────────────┐
     ▼                │ 持有List<Observer>  │     Customer      │
┌──────────┐          └───────────────────▶│───────────────────│
│   Shop   │                               │ - name            │
│──────────│   遍历并调用 onNotify()        │───────────────────│
│- shopName│──────────────────────────────▶│ + onNotify(...)   │
│- subscribers                              └───────────────────┘
└──────────┘
```

**关键**：`Shop` 只认识 `Observer` 接口，完全不知道 `Customer` 的存在——订阅者可以是顾客、可以是采购商、可以是爬虫，店铺代码零修改。

## 核心思想

### 先看不用观察者模式的写法（反面教材）

```java
public class Shop {
    private Customer xiaoming;   // 点名持有！
    private Customer xiaohong;
    // 新增一个订阅者类型？改 Shop！

    public void goodsArrive() {
        xiaoming.send("到货了");      // 挨个点名通知
        xiaohong.send("到货了");
        // 顾客没买到了想退订？Shop 里还要加逻辑！
    }
}
```

**问题**：
1. **强耦合**：Shop 写死了具体顾客类，换一类订阅者就得改 Shop
2. **违背开闭原则**：加订阅者、减订阅者都要改核心代码
3. **一对多关系被硬编码**：编译时定死了几个，运行时没法动态加减

### 用了观察者模式之后

```java
shop.subscribe(xiaoming);      // 动态加
shop.subscribe(xiaohong);
shop.unsubscribe(xiaoming);    // 动态减
shop.notifyAll(...);           // 一视同仁地通知，店铺不关心是谁
```

**对象间的依赖关系从"硬编码"变成了"运行时动态注册"。**

## 代码讲解

**被观察者接口**——"可被订阅"的标准：

```java
public interface Subject {
    void subscribe(Observer observer);    // 订阅
    void unsubscribe(Observer observer);  // 退订
    void notifyAll(String productName, String message);  // 通知所有订阅者
}
```

**观察者接口**——"收到通知后要做的事"：

```java
public interface Observer {
    void onNotify(String productName, String message);
}
```

**具体主题**——维护订阅者列表，到货时遍历通知：

```java
public class Shop implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void notifyAll(String productName, String message) {
        // 店铺不需要知道订阅者是谁，只管遍历通知
        for (Observer observer : subscribers) {
            observer.onNotify(productName, message);   // 逐个通知
        }
    }
}
```

**具体观察者**——每个人反应可以不同（这正是灵活性所在）：

```java
public class Customer implements Observer {
    @Override
    public void onNotify(String productName, String message) {
        System.out.println("  → 顾客【" + name + "】收到通知：" + productName + " - " + message);
    }
}
```

## 运行结果

```
【小米官方旗舰店】新用户订阅成功，当前订阅人数：1
【小米官方旗舰店】新用户订阅成功，当前订阅人数：2
【小米官方旗舰店】新用户订阅成功，当前订阅人数：3

【小米官方旗舰店】小米14 到货了！正在通知所有订阅者...
  → 顾客【小明】收到通知：小米14 - 现货充足，快去抢购！
  → 顾客【小红】收到通知：小米14 - 现货充足，快去抢购！
  → 顾客【小刚】收到通知：小米14 - 现货充足，快去抢购！

------------------------------
【小米官方旗舰店】用户取消订阅，当前订阅人数：2

【小米官方旗舰店】小米14 Pro 到货了！正在通知所有订阅者...
  → 顾客【小红】收到通知：小米14 Pro - 第二批到货，数量有限！
  → 顾客【小刚】收到通知：小米14 Pro - 第二批到货，数量有限！

==========================================
店铺只管通知，不关心谁在听；
顾客订阅后就等着收通知，不用一直去刷页面。
这就是观察者模式的精髓。
```

注意第二次通知小明收不到——**退订立即生效**，这就是动态订阅关系的价值。

## 适用场景

- **一个对象改变需要同时通知其他对象**，且不知道具体要通知多少个、谁
- **事件驱动**的场景：GUI 事件监听、消息推送、到货提醒、股价变动、MQ 消费者
- 需要在**运行时动态建立或解除**依赖关系
- 跨模块解耦：A 模块发生的事，B/C/D 模块关心，但 A 不该认识 B/C/D

## 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 松耦合：主题只认识抽象观察者 | ❌ 通知顺序不可控（遍历顺序） |
| ✅ 运行时动态订阅/退订 | ❌ 通知太多/太频繁会有性能问题 |
| ✅ 符合开闭原则，加订阅者零修改 | ❌ 循环依赖可能导致循环调用 |
| ✅ 广播通信，一对多天然支持 | ❌ 退订不当可能引起并发问题（见下） |

## 进阶讨论点（讲课/面试可用）

1. **⚠️ `notifyAll` 命名撞车 `Object.notifyAll()`**：`Object` 自带一个 `final void notifyAll()`（线程唤醒用）。这里的 `notifyAll(String, String)` 是重载，能编译，但写 `shop.notifyAll()` 不带参数就会调到 `Object` 的版本，在 `synchronized` 块外抛 `IllegalMonitorStateException`。GoF 标准命名刻意避开这个坑，叫 **`notifyObservers()`**（JDK 的 `java.util.Observable` 同理）。**建议改名 `notifySubscribers()` / `notifyObservers()`。**
2. **⚠️ 通知中退订会崩溃（经典陷阱）**：观察者在 `onNotify()` 回调里调用 `shop.unsubscribe(this)`，而 `notifyAll` 正在 for-each 遍历同一个列表 → 抛 `ConcurrentModificationException`。标准解法是**遍历副本**：

   ```java
   for (Observer observer : new ArrayList<>(subscribers)) {
       observer.onNotify(productName, message);
   }
   ```

   真实世界里"收到通知就退订"很常见（比如"到货后自动取消提醒"），这个坑必须知道。
3. **订阅查重**：`subscribe()` 不查重，同一顾客订阅两次会收到两份通知。生产上加 `if (!subscribers.contains(observer))`。
4. **push 模型 vs pull 模型**：本例是 **push**（主题把数据推给观察者）。另一种是 **pull**（主题只喊"我变了"，观察者自己来取数据），适合观察者只需要部分数据的场景。
5. **Java 自带的 `java.util.Observable` 为什么被抛弃**：它是个类不是接口（占用宝贵的继承位）、没有实现 `equals`、线程不支持差……现代 Java 用 `PropertyChangeListener`、RxJava、或框架事件总线（Spring `ApplicationEvent`、Guava `EventBus`）代替。

---

# 三、两个模式对比

| 维度 | 策略模式 | 观察者模式 |
|------|----------|------------|
| 解决什么问题 | **同一个行为有多种做法**，要能换 | **一个变了要通知多个**，要解耦 |
| 对象关系 | 上下文 → 一个策略（1对1，运行时换） | 主题 → 多个观察者（1对N，动态增减） |
| 核心手段 | 封装算法族，接口互换 | 订阅列表，广播通知 |
| 变化点 | "怎么做"在变 | "谁关心"在变 |
| 生活类比 | 到机场选出行方式 | 关注店铺到货提醒 |
| 典型场景 | 折扣/排序/压缩/路由 | 事件监听/消息推送/MQ |

**一句话记忆**：
- **策略**：换着法儿做同一件事
- **观察者**：一件事发生了，关心的人都知道

---

# 四、复习自测题

<details>
<summary>1. 策略模式和 if-else 比，到底好在哪？</summary>

新增算法时 if-else 要改已有方法（违反开闭原则），策略模式只需新增类；且算法可独立复用、独立测试、运行时切换。
</details>

<details>
<summary>2. 策略模式和模板方法怎么选？</summary>

两者都封装"变化的算法"。**策略**用组合，运行时能换，粒度是整个算法；**模板方法**用继承，编译时定死骨架里的某几步，适合"算法骨架不变、个别步骤变化"。优先用策略（组合优于继承），需要复用骨架时用模板方法。
</details>

<details>
<summary>3. 观察者模式是 push 还是 pull？</summary>

两种都有。push：主题把数据推给观察者（本例），简单但可能推了观察者不需要的数据；pull：主题只通知"变了"，观察者自己来取，灵活但多一次查询。
</details>

<details>
<summary>4. 观察者在回调里退订会发生什么？</summary>

正在遍历订阅者列表时修改列表，抛 `ConcurrentModificationException`。解法是遍历副本 `new ArrayList<>(subscribers)`，或用写时复制（CopyOnWriteArrayList）。
</details>

<details>
<summary>5. 为什么 GoF 把通知方法叫 notifyObservers 而不叫 notifyAll？</summary>

因为 `Object.notifyAll()` 是线程唤醒方法（final），重载这个名字容易误调到 Object 的版本，抛 `IllegalMonitorStateException`。命名避开 JDK 已有方法是基本功。
</details>

<details>
<summary>6. 观察者模式怎么保证通知顺序？</summary>

标准观察者不保证顺序（按列表遍历顺序）。需要顺序就用 `List` 的有序性显式控制，或者升级为有优先级的通知机制/消息队列。
</details>
