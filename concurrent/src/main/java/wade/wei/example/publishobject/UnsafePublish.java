package wade.wei.example.publishobject;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Administrator
 * 不安全的对象发布
 * 安全发布对象
 *  多线程并发环境下，线程安全极为重要。往往一些问题的发生都是由于不正确的发布了对象造成了对象逸出而引起的，
 * 因此如果系统开发中需要发布一些对象，必须要做到安全发布，以免造成安全隐患。
 * <p>
 * <p>
 * 发布对象：使一个对象能够被当前范围之外的代码所使用
 * 对象逸出：一种错误的发布情况，当一个对象还没有构造完成时，就使它被其他线程所见
 *
 * 安全发布对象
 *   安全发布对象的四种方法：
 *
 * 1. 在静态初始化函数中初始化一个对象引用
 * 2. 将对象的引用保存到volatile类型域或者AtomicReference对象中
 * 3. 将对象的引用保存到某个正确构造对象的final类型域中
 * 4. 将对象的引用保存到一个由锁保护的域中
 */
@Slf4j
public class UnsafePublish {
    private String[] arr = {"a", "b", "c"};

    public String[] getArr() {
        return arr;
    }

    /**
     *  以下代码通过public访问级别发布了类的域，
     * 在类的外部任何线程都可以访问这些域，这样发布对象是不安全的，
     * 因为我们无法假设，其他线程不会修改这些域，从而造成类状态的错误。
     * @param args
     */
    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();

        unsafePublish.getArr()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getArr()));

        unsafePublish.getArr()[0]="f";
        log.info("{}", Arrays.toString(unsafePublish.getArr()));
    }
}
