# DesignPattern

Java设计模式学习笔记

---

## 目录结构

```
src/
├── creational/              # 创建型模式
│   ├── abstractfactory/     # 抽象工厂模式
│   ├── builder/             # 生成器模式
│   ├── factorymethod/       # 工厂方法模式
│   ├── prototype/           # 原型模式
│   └── singleton/           # 单例模式
├── structural/              # 结构型模式（待学习）
└── behavioral/              # 行为型模式（待学习）
```

---

## 一、创建型模式

### 1. 抽象工厂模式（Abstract Factory）

#### 什么是抽象工厂模式？

**一句话**：提供一个接口，用于创建一系列相关的产品，而不需要指定具体类。

#### 生活中的例子：家具工厂

| 角色 | 对应类 |
|------|--------|
| 抽象工厂 | `AbstractFactory` - 定义能生产什么 |
| 现代工厂 | `ConcreteFactory1` - 生产现代家具 |
| 古典工厂 | `ConcreteFactory2` - 生产古典家具 |
| 抽象椅子 | `AbstractProductA` - 椅子接口 |
| 现代椅子 | `ProductA1` |
| 古典椅子 | `ProductA2` |
| 抽象桌子 | `AbstractProductB` - 桌子接口 |
| 现代桌子 | `ProductB1` |
| 古典桌子 | `ProductB2` |

#### UML类图

![抽象工厂模式类图](img/abstractfactory.png)

#### 图解说明

**1. 左侧 - 工厂部分**

```
┌─────────────────┐
│  AbstractFactory│  ← 抽象工厂接口
│  CreateProductA()│    定义"能生产什么"
│  CreateProductB()│
└────────┬────────┘
         │ 继承
    ┌────┴────┐
    ▼         ▼
┌──────────┐ ┌──────────┐
│Concrete   │ │Concrete   │  ← 具体工厂
│Factory1  │ │Factory2  │    实现具体生产逻辑
└──────────┘ └──────────┘
```

**2. 右侧 - 产品部分**

```
AbstractProductA（抽象产品A接口）
       ├── ProductA1（具体产品A1）
       └── ProductA2（具体产品A2）

AbstractProductB（抽象产品B接口）
       ├── ProductB1（具体产品B1）
       └── ProductB2（具体产品B2）
```

**3. 虚线箭头 - 依赖关系**

```
ConcreteFactory1 ┄┄┄→ ProductA1  （工厂1生产产品A1）
ConcreteFactory1 ┄┄┄→ ProductB1  （工厂1生产产品B1）
ConcreteFactory2 ┄┄┄→ ProductA2  （工厂2生产产品A2）
ConcreteFactory2 ┄┄┄→ ProductB2  （工厂2生产产品B2）
```

**4. Client（客户端）**

```
Client ────→ AbstractFactory      （使用工厂）
Client ────→ AbstractProductA     （使用产品A）
Client ────→ AbstractProductB     （使用产品B）
```

Client 只依赖抽象接口，不知道具体是哪个工厂或产品。

---

#### 图与代码的对应关系

| 图中元素 | 代码文件 | 说明 |
|---------|---------|------|
| AbstractFactory | `AbstractFactory.java` | 抽象工厂接口 |
| CreateProductA() | `createChair()` | 生产产品A的方法 |
| CreateProductB() | `createTable()` | 生产产品B的方法 |
| ConcreteFactory1 | `ConcreteFactory1.java` | 现代家具工厂 |
| ConcreteFactory2 | `ConcreteFactory2.java` | 古典家具工厂 |
| AbstractProductA | `AbstractProductA.java` | 椅子接口 |
| AbstractProductB | `AbstractProductB.java` | 桌子接口 |
| ProductA1 | `ProductA1.java` | 现代椅子 |
| ProductA2 | `ProductA2.java` | 古典椅子 |
| ProductB1 | `ProductB1.java` | 现代桌子 |
| ProductB2 | `ProductB2.java` | 古典桌子 |

#### 核心思想

1. **产品配套**：一个工厂只生产一种风格，不会混搭
2. **易于切换**：换风格 = 换工厂
3. **易于扩展**：新增风格 = 新增工厂类

#### 运行结果

```
=== 现代风格家具 ===
坐在现代简约椅子上，舒适简洁
在现代简约桌子上放东西，干净利落

=== 古典风格家具 ===
坐在古典雕花椅子上，优雅复古
在古典实木桌子上放东西，古色古香
```

#### 适用场景

- 系统需要多套产品系列（如：不同主题的UI组件）
- 需要确保产品配套使用
- 想要隔离具体类的依赖

#### 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 产品配套，不会混搭（华为手机配华为平板） | ❌ 新增产品类型困难（要改抽象工厂接口） |
| ✅ 易于切换风格（换个工厂就行） | ❌ 类数量增多（每个产品都要一个类） |
| ✅ 符合开闭原则（新增风格只加类） | ❌ 代码复杂度增加 |

---

### 2. 生成器模式（Builder Pattern）

#### 什么是生成器模式？

**一句话**：将复杂对象的构建过程与表示分离，同样的构建过程可以创建不同的表示。

#### 生活中的例子：造房子

| 角色 | 对应类 | 说明 |
|------|--------|------|
| 工头 | `Director` | 指挥建造流程，告诉工人先干什么再干什么 |
| 工人接口 | `Builder` | 定义建造步骤，但不知道具体怎么造 |
| 别墅施工队 | `VillaBuilder` | 实现别墅的建造 |
| 平房施工队 | `BungalowBuilder` | 实现平房的建造 |
| 房子 | `House` | 最终产品 |

#### UML类图

![生成器模式类图](img/builder.png)

#### 图解说明

**1. Director（指挥者/工头）**

```
Director
├── construct()    // 指挥建造流程
└── builder        // 持有建造者引用
```

**2. Builder（抽象建造者）**

```
Builder
├── buildFoundation()   // 打地基
├── buildWall()         // 砌墙
├── buildRoof()         // 盖屋顶
└── getResult()         // 获取结果
```

**3. ConcreteBuilder（具体建造者）**

```
VillaBuilder        BungalowBuilder
├── 别墅地基         ├── 平房地基
├── 别墅墙壁         ├── 平房墙壁
├── 别墅屋顶         ├── 平房屋顶
└── 返回别墅         └── 返回平房
```

#### 核心思想

```
Director（工头）只关心流程：
    buildFoundation() → buildWall() → buildRoof()

Builder（工人）关心实现：
    具体怎么打地基、怎么砌墙、怎么盖屋顶
```

#### 代码结构

```
Builder.java            // 抽象建造者接口
├── buildFoundation()   // 步骤1：打地基
├── buildWall()         // 步骤2：砌墙
├── buildRoof()         // 步骤3：盖屋顶
└── getResult()         // 获取产品

VillaBuilder.java       // 别墅施工队（具体建造者）
BungalowBuilder.java    // 平房施工队（具体建造者）

Director.java           // 工头（指挥者）
└── construct()         // 按顺序调用建造步骤

House.java              // 产品（房子）
```

#### 运行结果

```
=== 建造别墅 ===
工头：开始指挥建造...
别墅施工队：打别墅地基（深度5米，钢筋混凝土）
别墅施工队：砌别墅墙壁（三层，落地窗）
别墅施工队：盖别墅屋顶（坡屋顶，琉璃瓦）
工头：建造完成！
结果：房子 {地基='别墅地基（深度5米，钢筋混凝土）', 墙壁='别墅墙壁（三层，落地窗）', 屋顶='别墅屋顶（坡屋顶，琉璃瓦）'}

=== 建造平房 ===
工头：开始指挥建造...
平房施工队：打平房地基（深度2米，普通混凝土）
平房施工队：砌平房墙壁（一层，普通窗户）
平房施工队：盖平房屋顶（平顶，防水层）
工头：建造完成！
结果：房子 {地基='平房地基（深度2米，普通混凝土）', 墙壁='平房墙壁（一层，普通窗户）', 屋顶='平房屋顶（平顶，防水层）'}
```

#### 适用场景

- 对象有很多属性，有些可选
- 需要按步骤创建复杂对象
- 想要同样的流程创建不同类型的对象

#### 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 分离构建过程，同样的流程造不同产品 | ❌ 每个产品都要写一个Builder类 |
| ✅ 可以精细控制构建步骤 | ❌ 产品之间差异太大时不适用 |
| ✅ 链式调用更优雅（可选） | ❌ 增加了Director、Builder等类 |
| ✅ 不可变对象更容易实现 | ❌ 对于简单对象，反而增加复杂度 |

---

### 3. 工厂方法模式（Factory Method）

#### 什么是工厂方法模式？

**一句话**：让子类决定创建什么对象，父类只定义使用对象的流程。

#### 生活中的例子：数据库连接

| 角色 | 对应类 | 说明 |
|------|--------|------|
| 数据库工厂 | `DatabaseFactory` | 抽象工厂，定义连接流程 |
| MySQL工厂 | `MySQLFactory` | 创建MySQL连接 |
| Oracle工厂 | `OracleFactory` | 创建Oracle连接 |
| 数据库连接 | `DatabaseConnection` | 抽象产品，定义连接功能 |
| MySQL连接 | `MySQLConnection` | 具体产品1 |
| Oracle连接 | `OracleConnection` | 具体产品2 |

#### UML类图

![工厂方法模式类图](img/factorymethod.png)
#### 图解说明

**1. Creator（抽象工厂）**

```
DatabaseFactory（抽象工厂）
├── createConnection()    // 工厂方法：让子类实现
└── executeQuery()        // 业务方法：使用连接
```

**2. ConcreteCreator（具体工厂）**

```
MySQLFactory              OracleFactory
├── createConnection()    ├── createConnection()
└── return MySQL          └── return Oracle
```

**3. Product（抽象产品）**

```
DatabaseConnection（数据库连接接口）
├── connect()    // 连接
├── query()      // 查询
└── close()      // 关闭
```

**4. ConcreteProduct（具体产品）**

```
MySQLConnection           OracleConnection
├── 连接MySQL             ├── 连接Oracle
├── 执行MySQL查询         ├── 执行Oracle查询
└── 关闭MySQL连接         └── 关闭Oracle连接
```

#### 核心思想

```
父类（DatabaseFactory）：
    我要用连接，但不知道用哪个
    子类告诉我（createConnection）

子类（MySQLFactory/OracleFactory）：
    我知道创建哪个连接
    return new MySQLConnection()
```

#### 代码结构

```
DatabaseConnection.java       // 抽象产品：数据库连接接口
├── connect()
├── query()
└── close()

MySQLConnection.java          // 具体产品1：MySQL连接
OracleConnection.java         // 具体产品2：Oracle连接

DatabaseFactory.java          // 抽象工厂：定义流程
├── createConnection()        // 工厂方法（抽象）
└── executeQuery()            // 业务方法

MySQLFactory.java             // 具体工厂1：创建MySQL连接
OracleFactory.java            // 具体工厂2：创建Oracle连接
```

#### 运行结果

```
=== 使用 MySQL ===
MySQL工厂：创建MySQL连接
=== 开始执行查询 ===
连接 MySQL 数据库：jdbc:mysql://localhost:3306/mydb
MySQL 执行查询：SELECT * FROM users
关闭 MySQL 连接
=== 查询结束 ===

=== 使用 Oracle ===
Oracle工厂：创建Oracle连接
=== 开始执行查询 ===
连接 Oracle 数据库：jdbc:oracle:thin:@localhost:1521:orcl
Oracle 执行查询：SELECT * FROM orders
关闭 Oracle 连接
=== 查询结束 ===
```

#### 适用场景

- 不知道具体用哪个类（根据配置决定）
- 未来会加新品类（加新类不动旧代码）
- 想让子类决定创建什么对象

#### 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 符合开闭原则（加新品只加类） | ❌ 每个产品都要一个工厂类 |
| ✅ 解耦（父类不依赖具体类） | ❌ 类数量增多 |
| ✅ 易于扩展（加新工厂就行） | ❌ 对于简单场景有点过度设计 |

#### 与抽象工厂的区别

| 工厂方法 | 抽象工厂 |
|---------|---------|
| 一个工厂只生产**一种**产品 | 一个工厂生产**一系列**产品 |
| `createConnection()` | `createChair()` + `createTable()` |
| 简单，但产品多了工厂也多 | 产品配套，但结构复杂 |

---

### 4. 原型模式（Prototype Pattern）

#### 什么是原型模式？

**一句话**：用克隆代替new，复制已有对象来创建新对象。

#### 生活中的例子：简历投递

| 角色 | 对应 | 说明 |
|------|------|------|
| 简历模板 | `Resume` | 包含基本信息的模板 |
| 克隆方法 | `clone()` | 复制简历 |
| 投递简历 | 克隆后修改目标公司 | 不用重新写 |

#### UML类图

![原型模式类图](img/prototype.png)

#### 图解说明

**1. Prototype（原型接口）**

```
Prototype
└── Clone()  // 克隆方法，返回自己的副本
```

**2. ConcretePrototype（具体原型）**

```
Resume（简历）
├── name        // 姓名
├── education   // 学历
├── skills      // 技能
├── targetCompany  // 目标公司
└── Clone()     // 克隆自己，返回新简历
```

**3. Client（客户端）**

```
Client
├── 创建模板简历
├── 克隆简历1 → 修改目标公司
├── 克隆简历2 → 修改目标公司
└── 克隆简历3 → 修改目标公司
```

#### 核心思想

```
传统方式：new一个新对象，手动设置属性
    User user = new User();
    user.setName("张三");
    user.setAge(25);

原型模式：克隆已有对象
    User user = template.clone();
    user.setTargetCompany("阿里巴巴");
```

#### 代码结构

```
Resume.java     // 具体原型：简历
├── name, education, skills  // 基本信息（不变）
├── targetCompany            // 目标公司（可变）
└── clone()                  // 克隆方法

Client.java     // 测试类
├── 创建模板
├── 克隆多份简历
└── 修改目标公司
```

#### 运行结果

```
=== 创建简历模板 ===
模板内容：
姓名：张三
学历：本科
技能：Java, Python, 设计模式
目标公司：（待定）

=== 克隆简历投递不同公司 ===
--- 简历1 ---
姓名：张三
学历：本科
技能：Java, Python, 设计模式
目标公司：阿里巴巴

--- 简历2 ---
姓名：张三
学历：本科
技能：Java, Python, 设计模式
目标公司：腾讯

--- 简历3 ---
姓名：张三
学历：本科
技能：Java, Python, 设计模式
目标公司：字节跳动
```

#### 适用场景

- 对象创建成本高（比如要查数据库）
- 需要大量相似对象
- 想要保持对象状态不变

#### 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 简化对象创建（不用new + 设置属性） | ❌ 需要实现Cloneable接口 |
| ✅ 性能更好（克隆比new快） | ❌ 浅拷贝可能有问题（引用类型） |
| ✅ 保持对象状态 | ❌ 代码略复杂 |

#### 深拷贝 vs 浅拷贝

| 类型 | 说明 | 风险 |
|------|------|------|
| 浅拷贝 | 只复制基本类型，引用类型复制地址 | 修改一个会影响另一个 |
| 深拷贝 | 完全独立的副本 | 安全，但更耗性能 |

---

### 5. 单例模式（Singleton Pattern）

#### 什么是单例模式？

**一句话**：保证一个类只有一个实例，并提供全局访问点。

#### 生活中的例子：校长

一个学校只有一个校长，不管谁去找校长，找到的都是同一个人。

| 角色 | 对应 | 说明 |
|------|------|------|
| 学校 | Singleton类 | 整个系统只有一个 |
| 校长 | uniqueInstance | 唯一的实例 |
| 找校长 | getInstance() | 获取唯一实例的方法 |

#### UML类图

![单例模式类图](img/singleton.png)

#### 图解说明

**1. Singleton（单例类）**

```
Singleton
├── static Instance()       // 静态方法：获取唯一实例
├── SingletonOperation()    // 业务方法
├── GetSingletonData()      // 获取数据
├── static uniqueInstance   // 静态变量：保存唯一实例
└── singletonData           // 单例的数据
```

**2. 关键点**

```
构造函数私有化 → 不能从外部 new
静态变量 → 保存唯一的实例
静态方法 → 提供获取实例的入口
```

#### 核心思想

```
不管调用多少次 getInstance()，返回的都是同一个对象

Singleton s1 = Singleton.getInstance();
Singleton s2 = Singleton.getInstance();
s1 == s2  // true，同一个实例
```

#### 两种实现方式

| 方式 | 特点 | 适用场景 |
|------|------|---------|
| 懒汉式 | 用到时才创建（懒加载） | 实例创建开销大 |
| 饿汉式 | 类加载时就创建 | 实例创建开销小，需要快速访问 |

#### 代码结构

**懒汉式（SingletonLazy.java）**

```
private static SingletonLazy instance;  // 初始为null

public static SingletonLazy getInstance() {
    if (instance == null) {  // 第一次调用时才创建
        instance = new SingletonLazy();
    }
    return instance;
}
```

**饿汉式（SingletonHungry.java）**

```
private static SingletonHungry instance = new SingletonHungry();  // 类加载时就创建

public static SingletonHungry getInstance() {
    return instance;  // 直接返回，不用判断
}
```

#### 运行结果

```
=== 测试懒汉式 ===
懒汉式：实例被创建
s1 == s2 ? true
懒汉式单例执行业务逻辑

=== 测试饿汉式 ===
饿汉式：实例被创建
s3 == s4 ? true
饿汉式单例执行业务逻辑
```

#### 适用场景

- 数据库连接池（全局只有一个）
- 日志记录器（全局共享）
- 配置管理器（统一配置）
- 线程池（统一管理）

#### 优劣势

| 优势 | 劣势 |
|------|------|
| ✅ 节省内存（只有一个实例） | ❌ 懒汉式线程不安全（需要加锁） |
| ✅ 全局访问点 | ❌ 测试困难（单例难以mock） |
| ✅ 控制实例数量 | ❌ 可能造成全局状态 |

#### 懒汉式 vs 饿汉式

| 对比项 | 懒汉式 | 饿汉式 |
|--------|--------|--------|
| 创建时机 | 用到时才创建 | 类加载时就创建 |
| 线程安全 | 不安全（需加锁） | 安全 |
| 内存占用 | 延迟加载 | 提前占用 |
| 性能 | 第一次慢 | 第一次快 |

#### 懒汉式线程安全问题

**问题演示（SingletonUnsafe.java）**

```java
public static SingletonUnsafe getInstance() {
    if (instance == null) {        // 线程A判断null，准备创建
        instance = new SingletonUnsafe();  // 线程B也判断null，也创建
    }
    return instance;
}
```

**多线程测试结果**

```
启动10个线程，同时获取单例...

线程 Thread-0 获取到实例，hashCode=123456
线程 Thread-1 获取到实例，hashCode=789012  ← 不同的实例！
线程 Thread-2 获取到实例，hashCode=345678  ← 又一个不同的实例！

=== 结果分析 ===
总共创建了 3 个不同的实例
❌ 线程不安全！创建了多个实例！
```

**原因分析**

```
线程A：判断 instance == null → true
线程B：判断 instance == null → true（还没等线程A创建完）
线程A：创建实例
线程B：创建实例（覆盖了线程A的）
结果：两个实例！
```

#### 解决方案1：synchronized 方法

```java
public static synchronized SingletonSafe getInstance() {
    if (instance == null) {
        instance = new SingletonSafe();
    }
    return instance;
}
```

| 优点 | 缺点 |
|------|------|
| 简单 | 每次调用都加锁，效率低 |

#### 解决方案2：双重检查锁（推荐）

```java
public static SingletonDoubleCheck getInstance() {
    if (instance == null) {          // 第一次检查（不加锁）
        synchronized (SingletonDoubleCheck.class) {
            if (instance == null) {  // 第二次检查（加锁后确认）
                instance = new SingletonDoubleCheck();
            }
        }
    }
    return instance;
}
```

| 优点 | 缺点 |
|------|------|
| 只在第一次加锁，效率高 | 代码略复杂，需要volatile |

#### 三种实现方式对比

| 方式 | 线程安全 | 性能 | 复杂度 |
|------|---------|------|--------|
| 懒汉式（无锁） | ❌ 不安全 | 高 | 简单 |
| 懒汉式（synchronized） | ✅ 安全 | 低 | 简单 |
| 双重检查锁 | ✅ 安全 | 高 | 复杂 |
| 饿汉式 | ✅ 安全 | 高 | 简单 |

---

### 6. 创建型模式比较

#### 两种创建对象的方式

| 方式 | 对应模式 | 原理 |
|------|---------|------|
| **生成子类** | 工厂方法 | 通过继承，让子类决定创建什么 |
| **对象复合** | 抽象工厂、生成器、原型 | 通过组合，用一个"工厂对象"来创建 |

#### 逐个对比

| 模式 | 怎么创建对象 | 一句话特点 |
|------|-------------|-----------|
| **工厂方法** | 通过子类创建 | 简单，但产品多了工厂类也多 |
| **抽象工厂** | 用工厂对象创建**一系列**产品 | 产品配套，不会混搭 |
| **生成器** | 用工厂对象**逐步构建**复杂产品 | 分离流程和实现 |
| **原型** | 用工厂对象**克隆**已有产品 | 不用new，复制就行 |

#### 核心区别

```
工厂方法：用继承（子类决定）
抽象工厂/生成器/原型：用组合（工厂对象决定）
```

#### 选择指南

| 场景 | 推荐模式 |
|------|---------|
| 只有一种产品，简单创建 | 工厂方法 |
| 多种配套产品（如：主题UI） | 抽象工厂 |
| 复杂对象需要分步构建 | 生成器 |
| 对象创建成本高，需要复制 | 原型 |
| 全局只能有一个实例 | 单例 |

---

## 待学习

- [ ] 建造者模式
