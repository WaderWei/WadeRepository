package wade.wei.example.sync;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Administrator
 * synchronized
 * 修饰代码块：大括号括起来的代码，也称同步代码块，作用与调用的对象
 * 修饰方法：整个方法，也称同步方法，作用与调用的对象
 * 修饰静态方法：整个静态方法，作用于类的所有对象
 * 修饰类：括号括起来的部分，作用与类的所有对象
 */
@Slf4j
public class SyncStatic {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        /**
         * 静态方法上加锁与代码块锁SyncStatic.class，作用于所有类的对象
         * 以下同步
         */
        threadPoolExecutor.execute(()->test1());
        threadPoolExecutor.execute(()->test2());
        threadPoolExecutor.shutdown();
    }

    private static void test1() {
        //同步代码块
        synchronized (SyncStatic.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}", i);
            }
        }
    }

    /**
     * 同步方法 ，锁住的是调用此方法的对象
     */
    private static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {}", i);
        }
    }
}
