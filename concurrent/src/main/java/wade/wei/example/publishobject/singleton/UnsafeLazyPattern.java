package wade.wei.example.publishobject.singleton;

/**
 * @author Administrator
 * 存在并发问题
 * 赖汉模式 ：在第一次获取实例的时候创建对象
 */
public class UnsafeLazyPattern {
    private static UnsafeLazyPattern instance;

    private UnsafeLazyPattern() {

    }

    /**
     * 单线程下无问题，
     * @return
     */
    public static UnsafeLazyPattern getInstance() {
        //多线程会存在问题,多个线程可能都判断instance为null，多次创建对象
        if (instance == null) {
            instance = new UnsafeLazyPattern();
        }
        return instance;
    }
}
