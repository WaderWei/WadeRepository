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
public class SyncThis {
    public static void main(String[] args) {
        SyncThis syncThis1 = new SyncThis();
        SyncThis syncThis2 = new SyncThis();
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        /**
         * 成员方法上加锁与代码块锁this，仅仅作用与调用对象
         * 以下同步
         */
        //threadPoolExecutor.execute(()->syncThis1.test1());
        //threadPoolExecutor.execute(()->syncThis1.test2());

        /**
         * 不同对象不会同步
         */
        threadPoolExecutor.execute(()->syncThis1.test1());
        threadPoolExecutor.execute(()->syncThis2.test1());
        threadPoolExecutor.shutdown();
    }

    private void test1() {
        //同步代码块
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}", i);
            }
        }
    }

    /**
     * 同步方法 ，锁住的是调用此方法的对象
     */
    private synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {}", i);
        }
    }
}
