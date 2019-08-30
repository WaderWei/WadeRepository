package wade.wei.example.unsafeclass;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

/**
 * @author Administrator
 * 测试StringBuilder与StringBuffer
 * StringBuilder：线程不安全，效率高，一般用于方法内部字符串拼接，在方法中创建对象（堆栈封闭）
 * StringBuffer：线程安全，效率相对上面不高，全局安全
 */
@Slf4j
public class StringExample {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a->{
            testBuilder(a);
        });
        //线程不安全
        log.info("string builder {}",stringBuilder.length());

        ConcurrentTestTemplate.test(a->{
            testBuffer(a);
        });
        //线程安全
        log.info("string buffer {}",stringBuffer.length());
    }

    private static void testBuilder(int a) {
        stringBuilder.append(a);
    }

    private static void testBuffer(int a) {
        stringBuffer.append(a);
    }
}
