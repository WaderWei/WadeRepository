package wade.wei.decorator;

/**
 * 口红装饰
 */
public class LipStick extends Decorator {

    public LipStick(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("口红（");
        super.show();
        System.out.print(")");
    }
}
