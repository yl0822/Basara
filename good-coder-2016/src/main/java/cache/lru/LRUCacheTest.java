package cache.lru;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: Y. Long
 * CreateDate: 2015/6/1
 * CreateTime: 18:01
 * Location: com.zenointel.algorithm.storage.aws
 */
public class LRUCacheTest {
    // Test routine for the LRUCache class.
    public static void main(String[] args) {
        LRUCache<String, String> c = new LRUCache<String, String>(3);
        c.put("1", "one");                           // 1
        c.put("2", "two");                           // 2 1
        c.put("3", "three");                         // 3 2 1
        // 不管是get还是put，LinkedHashMap都会将操作对象排序到整个列表的最前位，所以非常适合用于LRU算法来进行缓存控制
//        c.get("1");
        c.put("4", "four");                          // 4 3 2
        if (c.get("2") == null) throw new Error();    // 2 4 3
        c.put("5", "five");                          // 5 2 4
        c.put("4", "second four");                   // 4 5 2
        // Verify cache content.
        if (c.usedEntries() != 3) throw new Error();
        if (!c.get("4").equals("second four")) throw new Error();
        if (!c.get("5").equals("five")) throw new Error();
        if (!c.get("2").equals("two")) throw new Error();
        // List cache content.
        for (Map.Entry<String, String> e : c.getAll())
            System.out.println(e.getKey() + " : " + e.getValue());
    }
}
