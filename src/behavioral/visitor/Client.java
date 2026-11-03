package behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端测试类
 * 演示访问者模式的精髓：元素类不动，操作随便加——
 * Excel/PDF/审计三种操作，挨个"访问"文档，元素类一行没改
 */
public class Client {

    public static void main(String[] args) {
        // 1. 财务文档集合（对象结构）：三种元素混在一起
        List<DocElement> docs = new ArrayList<>();
        docs.add(new Invoice("INV-001", 8000, 0.13));
        docs.add(new Bill("BILL-001", "小明", 500));
        docs.add(new Receipt("RCP-001", "2026-11-03", 120));

        // === 场景1：导出 Excel ===
        System.out.println("【场景1：导出 Excel】");
        DocVisitor excel = new ExcelExportVisitor();
        for (DocElement doc : docs) {
            doc.accept(excel);   // 元素.accept(访问者) —— 双分派！
        }

        System.out.println();

        // === 场景2：导出 PDF——元素类零修改，换个访问者就行 ===
        System.out.println("【场景2：导出 PDF（元素类零修改）】");
        DocVisitor pdf = new PdfExportVisitor();
        for (DocElement doc : docs) {
            doc.accept(pdf);
        }

        System.out.println();

        // === 场景3：审计统计——又一个新操作，元素类还是零修改 ===
        System.out.println("【场景3：审计统计（新操作，元素类依旧零修改）】");
        AuditVisitor audit = new AuditVisitor();
        for (DocElement doc : docs) {
            doc.accept(audit);
        }
        audit.report();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("三种文档 × 三种操作 = 9种组合，");
        System.out.println("但元素类只有 accept 一个方法，操作各自收在访问者类里。");
        System.out.println("加新操作 = 加一个访问者类，元素类一行不改。");
        System.out.println("这就是访问者模式的精髓：元素别动，操作上门。");
    }
}
