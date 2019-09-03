package wade.wei.example.future;

import lombok.extern.slf4j.Slf4j;
import wade.wei.utils.ThreadPoolExecutorFactory;

import java.util.concurrent.*;

/**
 * @author Administrator
 * FutureTask
 */
@Slf4j
public class FutureEg {
    static class MyCall implements Callable<String> {

        public MyCall() {

        }

        @Override
        public String call() throws Exception {
            log.info("before call");
            TimeUnit.MILLISECONDS.sleep(5000);
            return "done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        Future<String> submit = threadPoolExecutor.submit(new MyCall());
        log.info("main do something");
        TimeUnit.MILLISECONDS.sleep(2000);
        //调用future.get()时，如果此线程还没有执行完，即还没有返回结果，则主线程会一直等待，知道子线程返回结果为止
        String result = submit.get();
        log.info("结果为：{}", result);
        threadPoolExecutor.shutdown();
    }
}
