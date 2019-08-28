package wade.wei.concurrent2;

import lombok.extern.slf4j.Slf4j;
import wade.wei.entity.Person;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Administrator
 * 测试AtomicReference中为自定义对象，当修改自定义对象的属性时，能否保证原子性
 * <p>
 * AtomicReference 所提供的某些方法可以进行原子性操作，如compareAndSet、getAndSet，这仅仅是对<p>引用进行原子性操作</p>
 * AtomicReference  不能保证对象中若存在属性值修改是线程安全的，
 * 如假设引用对象是person，修改person中name和age，多个线程同时从引用中获得对象，
 * 并进行修改，会出现线程不安全情况。
 */
@Slf4j
public class AtomicReferenceExample6 {
    private static Person person = new Person(0, 0);
    private static AtomicReference<Person> atomicReference = new AtomicReference(person);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> modify(a));
        log.info("field1: {} ,field2 :{}", atomicReference.get().getField1(), atomicReference.get().getField2());
    }

    private static void modify(int i) {
        atomicReference.get().setField1(atomicReference.get().getField1() + i);
        atomicReference.get().setField2(atomicReference.get().getField2() + i);
    }
}
