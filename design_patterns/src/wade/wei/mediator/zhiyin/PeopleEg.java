package wade.wei.mediator.zhiyin;

/**
 * @author Administrator
 * 模拟两个人对话
 */
public class PeopleEg {
    private String name;
    private PeopleEg other;

    public PeopleEg(String name) {
        this.name = name;
    }

    /**
     * 连接其他人
     *
     * @param other
     */
    public void connect(PeopleEg other) {
        this.other = other;
    }

    /**
     * 讲话
     * 对方收听
     *
     * @param msg
     */
    public void talk(String msg) {
        other.listen(msg);
    }

    /**
     * 聆听来自对方的声音
     *
     * @param msg
     */
    public void listen(String msg) {
        System.out.println(other.getName() + " 对 " + this.name + " 说：" + msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
