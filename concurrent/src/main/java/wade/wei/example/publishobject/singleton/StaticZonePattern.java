package wade.wei.example.publishobject.singleton;

/**
 * @author Administrator
 * 静态域初始化
 * <p>
 * 静态域与静态代码块是顺序执行的，若将1 2 处位置进行交换则会出现空指针异常
 */
public class StaticZonePattern {
    //1
    private static StaticZonePattern instance;

    //2
    static {
        instance = new StaticZonePattern();
    }

    public static StaticZonePattern getInstance() {
        return instance;
    }
}
