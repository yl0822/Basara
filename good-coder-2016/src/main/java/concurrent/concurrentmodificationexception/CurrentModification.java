package concurrent.concurrentmodificationexception;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by long.yl
 * Created in 2016/8/4
 * Created on Basara_concurrent.concurrentmodificationexception
 */
public class CurrentModification {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        map.put("ddd", "444");
        map.put("eee", "555");
        map.put("fff", "666");
        System.out.println(JSON.toJSONString(map));
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if (stringStringEntry.getKey().equals("eee")){
                map.remove("fff");
            }
        }
        System.out.println(JSON.toJSONString(map));
    }
}
