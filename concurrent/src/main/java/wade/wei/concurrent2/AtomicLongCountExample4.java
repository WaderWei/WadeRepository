package wade.wei.concurrent2;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Administrator
 * 对比AtomicLong 与 LongAdder
 *
 */
@Slf4j
public class AtomicLongCountExample4 {
    //private static AtomicLong atomicLong = new AtomicLong(0);

    private static LongAdder adder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> add());
        //log.info("atomicLong count : {}", atomicLong.get());
        log.info("atomicLong count : {}", adder);
    }

    public static void add() {
        //atomicLong.incrementAndGet();
        adder.increment();
    }
}
