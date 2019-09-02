package wade.wei.mediator.zhiyin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ChatRoom {
    private String name;

    private List<People> peoples;

    public ChatRoom(String name) {
        this.name = name;
        this.peoples = new ArrayList<>();
    }

    public void connect(People people) {
        this.peoples.add(people);
        System.out.println(people.getName() + " -》 加入[" + this.name + "]聊天室");
    }

    public void sendMsg(People people, String msg) {
        peoples.stream().filter(p -> p != people).forEach(p -> p.listen(people, msg));
    }

}
