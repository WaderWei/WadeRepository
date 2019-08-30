package wade.wei.memento.zhiyin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 负责人Caretaker：编辑器
 */
public class Editor {
    private Document doc;
    private List<History> histories;
    private int historyIndex = -1;

    public Editor(Document doc) {
        System.out.println("<<<打开文档 " + doc.getTitle());
        this.doc = doc;
        histories = new ArrayList<>();
        backup();
        show();
    }

    private void show() {
        System.out.println(doc.getBody());
        System.out.println("文章结束》》》");
    }

    public void append(String body) {
        System.out.println("<<<插入操作");
        this.doc.setBody(this.doc.getBody() + body);
        backup();
        show();
    }

    public void save() {
        System.out.println("<<<存盘操作");
    }

    public void delete() {
        System.out.println("<<<删除操作");
        this.doc.setBody("");
        backup();
        show();
    }

    private void backup() {
        histories.add(doc.createHistory());
        historyIndex++;
    }

    public void undo() {
        System.out.println("撤销操作");
        if (historyIndex == 0) {
            return;//到头了
        }

        historyIndex--;
        History history = histories.get(historyIndex);
        this.doc.restoreHistory(history);
        show();
    }
}
