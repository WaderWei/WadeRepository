package wade.wei.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Administrator
 * 获取线程池对象
 */
public class ThreadPoolExecutorFactory {
    /**
     * 线程池中核心线程数的最大值
     */
    private final static int CORE_POOL_SIZE = 100;

    /**
     * 线程池中能拥有最多线程数
     */
    private final static int MAX_POOL_SIZE = 6000;

    /**
     * 表示空闲线程的存活时间
     */
    private final static Long KEEP_ALIVE_TIME = 60L;

    /**
     * 表示keepAliveTime的单位
     */
    private final static TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    /**
     * 指定创建线程的工厂
     */
    private final static ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    /**
     * workQueue：它决定了缓存任务的排队策略。对于不同的应用场景我们可能会采取不同的排队策略，这就需要不同类型的阻塞队列，在线程池中常用的阻塞队列有以下2种：
     * <p>
     * （1）SynchronousQueue<Runnable>：此队列中不缓存任何一个任务。向线程池提交任务时，如果没有空闲线程来运行任务，则入列操作会阻塞。
     * 当有线程来获取任务时，出列操作会唤醒执行入列操作的线程。从这个特性来看，SynchronousQueue是一个无界队列，
     * 因此当使用SynchronousQueue作为线程池的阻塞队列时，参数maximumPoolSizes没有任何作用。
     * <p>
     * （2）LinkedBlockingQueue<Runnable>：顾名思义是用链表实现的队列，可以是有界的，也可以是无界的，但在Executors中默认使用无界的。
     * 直接提交 SynchronousQueue
     * <p>
     * 无界队列 如LinkedBlockingQueue
     * <p>
     * 有界队列 如ArrayBlockingQueue
     */
    private final static BlockingQueue BLOCKING_QUEUE = new LinkedBlockingQueue<Runnable>();

    /**
     * handler： 线程池对拒绝任务的处理策略
     * <p>
     * ThreadPoolExecutor.AbortPolicy()  抛出java.util.concurrent.RejectedExecutionException异常。
     * <p>
     * ThreadPoolExecutor.CallerRunsPolicy()  重试添加当前的任务，他会自动重复调用execute()方法。
     * <p>
     * ThreadPoolExecutor.DiscardOldestPolicy()  抛弃旧的任务
     * <p>
     * ThreadPoolExecutor.DiscardPolicy()  抛弃当前的任务。
     */
    private final static RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, BLOCKING_QUEUE, THREAD_FACTORY, HANDLER);
    }
}
