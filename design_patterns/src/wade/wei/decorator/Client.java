package wade.wei.decorator;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
       new EyeLiner(new LipStick(new Girl("TT"))).show();
    }
}
