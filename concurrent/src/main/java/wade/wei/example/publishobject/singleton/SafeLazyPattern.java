package wade.wei.example.publishobject.singleton;

/**
 * @author Administrator
 * 线程安全
 */
public class SafeLazyPattern {
    /**
     * 禁止重排序优化
     */
    private volatile static SafeLazyPattern instance;

    private SafeLazyPattern() {

    }

    /**
     * JVM指令排序优化，不加volatile会导致指令重排序
     * 创建对象步骤
     * 1. 开辟内存空间
     * 2. 创建实例
     * 3. 将实例指向内存空间
     *
     * 指令重排序
     * 1. 开辟内存空间
     * 3. 将实例指向内存空间
     * 2. 创建实例
     * @return
     */
    public static SafeLazyPattern getInstance() {
        if (instance == null) {
            synchronized (SafeLazyPattern.class) {
                if (instance == null) {
                    instance = new SafeLazyPattern();
                }
            }
        }
        return instance;
    }
}
