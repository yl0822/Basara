package good.code.manner;


import good.code.manner.enum_annotation_acl.Access;
import good.code.manner.enum_annotation_acl.Foo;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner
 */
public class App {
    public static void main(String[] args) {
        System.out.println(StringUtils.equals(null, null));
        System.out.println(StringUtils.equals(null, ""));
        System.out.println(StringUtils.equals("", null));
        System.out.println(StringUtils.equals("", ""));
        System.out.println(StringUtils.equals("", ""));
        System.out.println(StringUtils.equals("", ""));
    }
}
