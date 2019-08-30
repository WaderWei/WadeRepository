package wade.wei.memento.csdn;

/**
 * @author Administrator
 */
public class Client {
    private static int index = -1;
    private static MementoCaretaker mementoCaretaker = new MementoCaretaker();

    public static void main(String[] args) {
        Chessman chessman = new Chessman("车", 1, 1);
        play(chessman);
        chessman.setX(4);
        play(chessman);
        chessman.setY(5);
        play(chessman);
        undo(chessman,index);
        undo(chessman,index);
        redo(chessman,index);
        redo(chessman,index);
    }

    /**
     * 下棋的同时保存备忘录
     */
    public static void play(Chessman chessman) {
        mementoCaretaker.addChessmanMemento(chessman.save());
        index++;
        chessman.show();
    }

    public static void undo(Chessman chessman, int i) {
        System.out.println("-----------悔棋-------------");
        index--;
        chessman.restore(mementoCaretaker.getChessmanMemento(i - 1));
        chessman.show();
    }

    public static void redo(Chessman chessman, int i) {
        System.out.println("------------撤销悔棋---------------");
        index++;
        chessman.restore(mementoCaretaker.getChessmanMemento(i + 1));
        chessman.show();
    }
}
