package wade.wei.concurrent2;


import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Administrator
 * 保证高并发情况下某个逻辑仅第一个线程会执行一次
 */
@Slf4j
public class AtomicBooleanExample7 {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> update());
    }

    private static void update() {
        if (atomicBoolean.compareAndSet(false, true)) {
            log.info(" execute only once");
        }
    }
}
