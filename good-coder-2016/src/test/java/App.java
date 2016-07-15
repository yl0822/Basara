import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by long.yl on 2016/7/11.
 */
public class App {
    public int i;

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        TreeMap<String, Object> treeMap = new TreeMap<>();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        hashMap.put("aaa", new Object());
        hashMap.put("ccc", new Object());
        hashMap.put("222", new Object());
        hashMap.put("bbb", new Object());
        hashMap.put("111", new Object());
        hashMap.put("333", new Object());
        hashMap.put("abs3", new Object());

        System.out.println(Arrays.toString(hashMap.keySet().toArray()));

        treeMap.put("aaa", new Object());
        treeMap.put("ccc", new Object());
        treeMap.put("222", new Object());
        treeMap.put("bbb", new Object());
        treeMap.put("111", new Object());
        treeMap.put("333", new Object());
        treeMap.put("abs3", new Object());

        System.out.println(Arrays.toString(treeMap.keySet().toArray()));

        linkedHashMap.put("aaa", new Object());
        linkedHashMap.put("ccc", new Object());
        linkedHashMap.put("222", new Object());
        linkedHashMap.put("bbb", new Object());
        linkedHashMap.put("111", new Object());
        linkedHashMap.put("333", new Object());
        linkedHashMap.put("abs3", new Object());

        System.out.println(Arrays.toString(linkedHashMap.keySet().toArray()));

    }

    public void print() {
        System.out.println(" i = " + i);
    }
}
