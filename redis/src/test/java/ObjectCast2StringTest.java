import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public class ObjectCast2StringTest {

    @Test
    public void doCast() {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "bbb");
        System.out.println(map.get("aaa"));
        System.out.println(map.get("aaa").toString());
        System.out.println((String) map.get("aaa"));
    }
}
