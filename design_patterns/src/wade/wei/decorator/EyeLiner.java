package wade.wei.decorator;

/**
 * @author Administrator
 */
public class EyeLiner extends Decorator {
    public EyeLiner(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("眼线（");
        super.show();
        System.out.print("）");
    }
}
