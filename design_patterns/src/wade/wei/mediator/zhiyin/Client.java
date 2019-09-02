package wade.wei.mediator.zhiyin;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
       /* PeopleEg wade = new PeopleEg("wade");
        PeopleEg jack = new PeopleEg("jack");
        wade.connect(jack);
        jack.connect(wade);

        wade.talk("jack，hello");

        jack.talk("hello，wade");*/

        ChatRoom many_chatroom = new ChatRoom("many chatroom");
        People wade = new People("wade");
        People jack = new People("jack");
        People peter = new People("peter");

        wade.login(many_chatroom);
        jack.login(many_chatroom);
        peter.login(many_chatroom);

        wade.talk("everyone");
        jack.talk("pi");
    }
}
