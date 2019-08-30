package wade.wei.template;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import wade.wei.interfaces.Modify;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author Administrator
 * 并发测试模板，基本上所有的测试都用这个方法
 * 即模拟5000个客户请求，同时执行的线程为200个
 */
@Slf4j
public class ConcurrentTestTemplate {
    /**
     * 客户端请求数量
     */
    private static int clientTotal = 5000;

    /**
     * 同时执行的线程数
     */
    private static int threadTotal = 200;


    /**
     * 信号量，Semaphore可以阻塞进程并且控制同时访问的线程个数，
     * 通过 acquire() 获取一个许可，如果没有就等待，
     * 而 release() 释放一个许可。Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
     * <p>
     * Semaphore适合控制并发数
     * CountDownLatch比较适合保证线程执行完后再执行其他处理
     */

    public static void test(Modify<Integer> modify) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        //定义一个指定初始值（许可证）的信号量,确保能够同时执行的线程数量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //等待所有的请求执行完
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int a = i;
            threadPoolExecutor.execute(() -> {

                try {
                    semaphore.acquire();
                    modify.modify(a);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.info("线程在执行过程中发生的异常：{}", e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        //当前线程一直等待到countDownLatch中维护的初始值为0，则不再等待然后放行
        countDownLatch.await();
        //关闭线程池
        threadPoolExecutor.shutdown();
    }
}
