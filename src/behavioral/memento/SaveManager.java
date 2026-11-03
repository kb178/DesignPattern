package behavioral.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * 负责人（管理者）- 存档管理器
 *
 * 负责：保管、读取备忘录（就像游戏的存档位）
 * 不能：查看或修改备忘录内容 —— 对它来说 GameSave 是不透明的黑箱
 *
 * 就像游戏的"存档位"界面：帮你管理一堆存档文件，
 * 但它根本不关心（也没法关心）存档里是什么数据。
 */
public class SaveManager {

    private final Map<String, GameRole.GameSave> saveSlots = new HashMap<>();

    /** 存档到指定存档位 */
    public void save(String slotName, GameRole.GameSave save) {
        saveSlots.put(slotName, save);
        System.out.println("  [存档管理器] 已保存到【" + slotName + "】");
    }

    /** 从指定存档位读档 */
    public GameRole.GameSave load(String slotName) {
        System.out.println("  [存档管理器] 读取【" + slotName + "】");
        return saveSlots.get(slotName);
    }
}
