package wade.wei.example.atomic;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * 线程安全
 */
@Slf4j
public class AtomicCountExample3 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> add());
        log.info("atomicInteger count : {}", atomicInteger.get());
    }

    private static void add() {
        atomicInteger.incrementAndGet();
    }
}
