package wade.wei.example.publishobject.singleton;

/**
 * @author Administrator
 * 饿汉模式：在类装载时进行创建
 * 不会引发线程安全问题
 * 缺点：1.若构造方法中存在过多的处理、会导加载缓慢，从而引起性能问题
 * 2.只进行加载，并无实际调用，导致资源浪费
 */
public class HungryPatter {
    private static HungryPatter instance = new HungryPatter();

    private HungryPatter() {

    }

    public static HungryPatter getInstance() {
        return instance;
    }
}
