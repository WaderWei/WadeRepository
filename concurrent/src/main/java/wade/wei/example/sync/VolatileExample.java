package wade.wei.example.sync;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * volatile
 * ​ 通过加入内存屏障和禁止重排序优化来实现
 * <p>
 * 结论：
 * volatile进行加操作线程不安全的，不适合计数场景
 * volatile关键字不具有原子性
 * <p>
 * 使用场景
 * 使用volatile必须具备两个条件
 * 对变量的写操作，不依赖于当前值
 * 该变量没有包含在具有其他变量的不变式子中
 * 因此volatile适合作为状态的标记量
 */
@Slf4j
public class VolatileExample {
    /**
     * 被volatile修饰的变量一经修改，其他线程会立即可见
     */
    private static volatile boolean isChange = false;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        threadPoolExecutor.execute(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
                isChange = true;
                log.info("{} 当前时间：{}",Thread.currentThread().getName(),System.currentTimeMillis());//打印时间与下面相同
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPoolExecutor.execute(() -> {
            while (!isChange) {
                log.info("idChange value: {}" , isChange);
            }
            log.info("{} 当前时间：{}",Thread.currentThread().getName(),System.currentTimeMillis());//打印时间与下面相同
        });

        threadPoolExecutor.shutdown();
    }
}
