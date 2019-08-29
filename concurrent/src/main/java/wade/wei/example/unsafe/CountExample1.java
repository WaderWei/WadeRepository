package wade.wei.example.unsafe;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

/**
 * @author Administrator
 * 计数,线程不安全
 */
@Slf4j
public class CountExample1 {

    private static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> add());
        log.info("count = {}", count);
    }

    private static void add() {
        count++;
    }
}
