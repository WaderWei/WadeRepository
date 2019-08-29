package wade.wei.interfaces;

import java.util.List;

/**
 * @author Administrator
 * 用于函数式编程传递方法
 */
@FunctionalInterface
public interface Modify<T> {
    /**
     * 用于变化逻辑的传递
     * @param t
     */
    void modify(T t);
}
