package wade.wei.example.future;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
@Slf4j
public class FutureEg2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("call do something");
                TimeUnit.MILLISECONDS.sleep(1000);
                return "done";
            }
        });

        log.info("main do something");
        while (!submit.isDone()) {
            log.info("等待中。。。");
        }

        String result = submit.get();
        log.info("result:{}", result);
        threadPoolExecutor.shutdown();
    }
}
