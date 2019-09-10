package wade.wei.combination;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {
    /**
     * 文件夹可以包含子文件
     */
    private List<Node> childrenNodes = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    /**
     * 还能再添加文件
     *
     * @param child
     */
    @Override
    public void add(Node child) {
        childrenNodes.add(child);
    }

    @Override
    protected void ls(int space) {
        super.ls(space);
        space++;
        for (Node childrenNode : childrenNodes) {
            childrenNode.ls(space);
        }
    }
}
