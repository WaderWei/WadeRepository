package wade.wei.example.collections;

import lombok.extern.slf4j.Slf4j;
import wade.wei.template.ConcurrentTestTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Administrator
 * 同步容器
 */
@Slf4j
public class SyncCollection {
    private static List<Integer> list = Collections.synchronizedList(new ArrayList<>());

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

    private static ConcurrentMap<Integer,Integer> concurrentMap=new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTestTemplate.test(a->{
            test(a);
        });
        log.info("list {}; set {}; map {}; concurrentMap {}",list.size(),set.size(),map.size(),concurrentMap.size());
    }

    private static void test(int a){
        list.add(a);
        set.add(a);
        map.put(a,a);
        concurrentMap.put(a,a);
    }
}
