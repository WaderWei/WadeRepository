package wade.wei.decorator;

/**
 * @author Administrator
 */
public class Girl implements Showable {
    protected String name;

    public Girl(String name) {
        this.name = name;
    }


    @Override
    public void show() {
        System.out.print("素面朝天");
    }
}
