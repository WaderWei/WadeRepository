package wade.wei.example.aqs;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * 信号量
 */
@Slf4j
public class SemaphoreEg {
    /**
     * 总的请求数
     */
    private final static int clientTotal = 10;
    /**
     * 同时允许的线程数
     */
    private final static int threadTotal = 3;

    //模拟每秒允许三个线程同时执行
    public static void main(String[] args) {
        final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(threadTotal);
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        for (int i = 0; i < clientTotal; i++) {
            final int a = i;
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    log.info(a + "");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.info(e.getLocalizedMessage());
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

}
