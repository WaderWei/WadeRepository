package wade.wei.memento.zhiyin;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
        Document dd = new Document("dd");
        Editor editor = new Editor(dd);
        editor.append("one；");
        editor.append("two；");
        editor.append("three；");

        editor.delete();

        editor.undo();
    }
}
