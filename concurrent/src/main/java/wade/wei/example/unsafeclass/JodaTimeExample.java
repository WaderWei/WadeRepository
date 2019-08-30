package wade.wei.example.unsafeclass;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import wade.wei.template.ConcurrentTestTemplate;

/**
 * @author Administrator
 * 在使用日期转换的时候，更建议使用JodaTime所提供的日期转换类，
 * 不仅是因为它是线程安全的，而且在类实际处理转换中有其他的优势。
 */
@Slf4j
public class JodaTimeExample {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> {
            test();
        });
    }

    private static void test() {
        DateTime dateTime = dateTimeFormatter.parseDateTime("2018-01-01");
        log.info("dateTime : {}", dateTime);
    }
}
