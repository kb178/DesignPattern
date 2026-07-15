package structural.adapter;

/**
 * 美国电器 - 美国笔记本电脑
 * 只能使用110V电源（接口不兼容）
 */
public class USLaptop implements Electronic {

    @Override
    public void usePower() {
        System.out.println("美国笔记本：使用110V电源，正常工作");
    }
}
