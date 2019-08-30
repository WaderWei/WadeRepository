package wade.wei.memento.csdn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * Caretaker（负责人）：负责人又称为管理者，它负责保存备忘录，但是不能对备忘录的内容进行操作或检查。
 * 在负责人类中可以存储一个或多个备忘录对象，它只负责存储对象，而不能修改对象，也无须知道对象的实现细节。
 */
public class MementoCaretaker {
    private List<ChessmanMemento> chessmanMementos = new ArrayList<>();

    public ChessmanMemento getChessmanMemento(int i) {
        return chessmanMementos.get(i);
    }

    public void addChessmanMemento(ChessmanMemento chessmanMemento) {
        this.chessmanMementos.add(chessmanMemento);
    }
}
