package wade.wei.example.unsafeclass;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * 当方法运行的时候，则会抛出异常，
 * 原因是SimpleDateFormat在多线程下共享使用就会出现线程不安全情况。
 * 建议将SimpleDateFormat声明为局部变量，这样才会避免线程不安全所带来的异常
 */
@Slf4j
public class DateFormatExample {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> test());
    }

    private static void test() {
        try {
            //将字符串转换成日期
            Date parse = dateFormat.parse("2018-01-01");
        } catch (ParseException e) {
            log.info(" exception {}", e.getMessage());
        }
    }
}
