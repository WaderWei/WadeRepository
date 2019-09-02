package wade.wei.example.aqs;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@Slf4j
public class CyclicBarrierEg {
    final static int count = 100;
    final static CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
        log.info("先凉5s");
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("其他线程先做到[cyclicBarrier.await()],然后这个线程执行完，其他线程再继续执行");
    });

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        for (int i = 0; i < count; i++) {
            final int a = i;
            threadPoolExecutor.execute(() -> {
                log.info("报道：{}", a);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                log.info("走起：{}", a);
            });
        }
        threadPoolExecutor.shutdown();
    }
}
