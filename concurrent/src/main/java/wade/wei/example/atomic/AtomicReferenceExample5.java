package wade.wei.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Administrator
 * 原子性引用
 */
@Slf4j
public class AtomicReferenceExample5 {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        //将期望值与工作中的变量值作对比，如果相同则更新成update值
        //true ,2
        atomicReference.compareAndSet(0, 2);
        //false 2
        atomicReference.compareAndSet(0, 3);
        //true 4
        atomicReference.compareAndSet(2, 4);
        //false 4
        atomicReference.compareAndSet(2, 5);
        //4
        log.info("atomicReference value {}", atomicReference.get());
    }
}
