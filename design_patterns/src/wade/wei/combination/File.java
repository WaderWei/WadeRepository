package wade.wei.combination;

/**
 * @author Administrator
 * 文件，不能再添加子文件
 */
public class File extends Node{

    public File(String name) {
        super(name);
    }

    @Override
    public void add(Node child) {
        System.out.println("无法再添加文件了");
    }
}
