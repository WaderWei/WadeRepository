package wade.wei.mediator.zhiyin;

/**
 * @author Administrator
 * 每个用户不再所持有其他所有用户的引用了，
 * 取而代之的是聊天室的引用，这样引用关系瞬间变得明朗起来，开始我们的代码重构。
 */
public class People {
    private String name;

    private ChatRoom chatRoom;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void login(ChatRoom chatRoom) {
        chatRoom.connect(this);
        this.chatRoom = chatRoom;
    }

    public void talk(String msg) {
        this.chatRoom.sendMsg(this, msg);
    }

    public void listen(People fromWhom, String msg) {
        System.out.println(this.name + " 的对话框");
        System.out.println(fromWhom.getName() + " 说：" + msg);
    }
}
