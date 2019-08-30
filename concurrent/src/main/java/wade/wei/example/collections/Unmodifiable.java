package wade.wei.example.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Administrator
 * Collections
 * ​ java提供Collections工具类，在类中提供了多种不允许修改的方法
 * ​ Collections.unmodifiableXXX：Collection、List、Set、Map...
 */
@Slf4j
public class Unmodifiable {

    private static List<Integer> list;
    private static Set<Integer> set;
    private static Map<Integer, Integer> map;

    static {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        list = Collections.unmodifiableList(integerList);

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        set = Collections.unmodifiableSet(integerSet);

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 1);
        integerMap.put(2, 2);
        map = Collections.unmodifiableMap(integerMap);
    }

    public static void main(String[] args) {

        /**都会报此异常
         * Exception in thread "main" java.lang.UnsupportedOperationException
         * 	at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
         * 	at wade.wei.example.collections.Unmodifiable.main(Unmodifiable.java:38)
         */
        //log.info("list  {}", list.add(10));

        //log.info("set  {}", set.add(10));

        //log.info("map  {}", map.put(10, 10));
    }
}
