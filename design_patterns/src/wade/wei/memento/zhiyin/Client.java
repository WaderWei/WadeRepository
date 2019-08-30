package wade.wei.memento.zhiyin;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
        Document dd = new Document("dd");
        Editor editor = new Editor(dd);
        editor.append("sssss");
        editor.append("ffffff");
        editor.append("cccccccc");

        editor.delete();

        editor.undo();
    }
}
