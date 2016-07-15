package tools.netease.basara;

import java.util.Map;

/**
 * @author long.yl.
 * @Date 2016/1/14
 */
public class MapBasara {
    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static void print(Map<String, ?> map) {
        if (isNullOrEmpty(map)) {
            return;
        }
        StringBuilder sb = new StringBuilder("start to print map ,size : ").append(map.size()).append(" as follow....");
        int num = 0;
        for (String key : map.keySet()) {
            sb.append(System.getProperties().get("line.separator"));
            sb.append(num++);
            sb.append(" key: ");
            sb.append(key);
            sb.append(", value: ");
            sb.append(map.get(key));
        }
        System.out.println(sb.toString());
    }
}
