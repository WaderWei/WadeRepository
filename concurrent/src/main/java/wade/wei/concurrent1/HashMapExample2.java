package wade.wei.concurrent1;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * 向hashMap中添加元素，线程不安全
 */
@Slf4j
public class HashMapExample2 {
    private static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a -> add(a));
        log.info("hashMap size : {}", hashMap.size());
    }

    private static void add(int i) {
        hashMap.put(i, i);
    }
}
