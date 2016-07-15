package cache.fifo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by long.yl on 2016/7/12.
 */
public class FIFOCache {
    private LinkedList<String> list;

    private Map<String, String> map;

    private int cacheSize;

    public FIFOCache(int cacheSize) {
        this.cacheSize = cacheSize;
        list = new LinkedList<>();
        map = new HashMap<>(cacheSize);
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(3);
        cache.add("1", "aaa");
        cache.add("2", "bbb");
        cache.add("3", "ccc");
        cache.add("4", "ddd");
        System.out.println(cache.get("1"));
    }

    public synchronized void add(String key, String value) {
        if (list.size() >= cacheSize) {
            map.remove(list.removeFirst());
        }
        list.add(key);
        map.put(key, value);
    }

    public synchronized String get(String key) {
        return map.get(key);
    }
}
