package wade.wei.example.aqs;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@Slf4j
public class CountDownLatchEg {
    private final static int threadCount = 100;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int para = i;
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    log.info("参数：{}", para);
                } catch (InterruptedException e) {
                    log.info(e.getLocalizedMessage());
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        log.info("等待。。。。。。");
        countDownLatch.await();
        log.info("結束等待。");
        threadPoolExecutor.shutdown();
    }

}
