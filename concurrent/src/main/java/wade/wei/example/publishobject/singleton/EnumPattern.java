package wade.wei.example.publishobject.singleton;

/**
 * @author Administrator
 * 最安全的单例模式
 */
public class EnumPattern {
    //私有化构造函数
    private EnumPattern() {

    }

    public static EnumPattern getInstance() {
        return SingleTon.INSTACE.getInstace();
    }

    /**
     * 由枚举创建实例
     */
    private enum SingleTon {
        INSTACE;

        private EnumPattern enumPattern;

        SingleTon() {
            enumPattern = new EnumPattern();
        }

        public EnumPattern getInstace() {
            return enumPattern;
        }
    }
}
