package wade.wei.example.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * @author Administrator
 * Guava
 * ​ 谷歌的Guava提供类似Java中的Collections
 * ​ ImmutableXXX：Collection、List、Set、Map...
 */
public class Immutable {
    private final static ImmutableList<Integer> LIST = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet SET = ImmutableSet.of(1, 2, 3);
    private final static ImmutableMap<Integer, Integer> MAP = ImmutableMap.<Integer, Integer>builder().put(1, 1).put(2, 2).build();

    public static void main(String[] args) {
        /**
         * Exception in thread "main" java.lang.UnsupportedOperationException
         * 	at com.google.common.collect.ImmutableCollection.add(ImmutableCollection.java:221)
         * 	at wade.wei.example.collections.Immutable.main(Immutable.java:19)
         */
        LIST.add(10);
    }
}
