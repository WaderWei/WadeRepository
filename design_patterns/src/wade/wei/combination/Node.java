package wade.wei.combination;

/**
 * 组合模式：树形结构以表达部分和整体的层次结构，模糊部分与整体
 */
public abstract class Node {
    protected String name;

    public Node(String name) {
        this.name = name;
    }

    /**
     * 添加节点
     *
     * @param child
     */
    protected abstract void add(Node child);

    protected void ls(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(name);
    }

    protected void ls() {
        ls(0);
    }
}
